import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
 * Build an app that allows you to find events
 */
class EventHub {
  record Location(String name, int x, int y) {
  }

  record Event(String name, String location, LocalDate date) {
  }

  interface EventRepository {
    List<Event> list();
  }

  interface LocationRepository {
    List<Location> list();
  }

  public static class InMemoryLocationRepository implements LocationRepository {
    private List<Location> locations = Arrays.asList(
        new Location("new york city", 20, 30),
        new Location("dublin", -20, 35),
        new Location("san francisco", 40, 20),
        new Location("paris", -20, 15));

    @Override
    public List<EventHub.Location> list() {
      return this.locations;
    }
  }

  public static class InMemoryEventRepository implements EventRepository {
    private List<EventHub.Event> events = Arrays.asList(
        new EventHub.Event("eiffel 65", "paris", LocalDate.now()),
        new EventHub.Event("eminem concert", "new york city", LocalDate.now().plusDays(45)),
        new EventHub.Event("kelly klarkson concert", "new york city", LocalDate.now().plusDays(-90)),
        new EventHub.Event("rihanna concert", "new york city", LocalDate.now().plusDays(-290)),
        new EventHub.Event("kelly klarkson concert", "san francisco", LocalDate.now().plusDays(145)),
        new EventHub.Event("shakira", "paris", LocalDate.now().plusDays(1)));

    @Override
    public List<EventHub.Event> list() {
      return this.events;
    }
  }

  private EventRepository repo;
  private LocationRepository locationRepository;

  public EventHub(final EventRepository repo, final LocationRepository locationRepo) {
    this.repo = repo;
    this.locationRepository = locationRepo;
  }

  public List<Event> listEvents() {
    return this.listEvents(c -> true, 10);
  }

  public static class DateFilter implements Predicate<Event> {
    private final LocalDate date;

    public DateFilter(final LocalDate date) {
      this.date = date;
    }

    @Override
    public boolean test(final Event t) {
      return t.date.compareTo(date) <= 0;
    }
  }

  public List<Event> listEvents(final Predicate<Event> filter, final int limit) {
    return this.listEvents(filter, (a, b) -> Long.compare(b.date.toEpochDay(), a.date.toEpochDay()), limit);
  }

  public static class ManhattanDistanceComparator implements Comparator<Event> {
    private final Map<String, Location> locations;
    private final Location target;

    public ManhattanDistanceComparator(final EventHub hub, final Location target) {
      var locationMap = hub.listLocations()
          .stream()
          .collect(Collectors.toMap(l -> l.name, l -> l));

      this.locations = locationMap;
      this.target = target;
    }

    @Override
    public int compare(EventHub.Event o1, EventHub.Event o2) {
      var city1 = locations.get(o1.location);
      var distance1 = (target.x + target.y) - (city1.x + city1.y);
      var city2 = locations.get(o2.location);
      var distance2 = (target.x + target.y) - (city2.x + city2.y);
      return Math.abs(distance1) - Math.abs(distance2);
    }
  }

  public List<Event> listEvents(final Predicate<Event> filter, final Comparator<Event> sort, final int limit) {
    return repo.list()
        .stream()
        .filter(filter)
        .sorted(sort)
        .limit(limit)
        .collect(Collectors.toList());
  }

  public List<Location> listLocations() {
    return locationRepository.list();
  }

  public static <T> void printHelper(final String message, final Stream<T> toPrint) {
    final var size = message.length();
    final var starsToPrint = "*".repeat(size + 4);
    System.out.println(starsToPrint);
    System.out.println(String.format("* %-" + size + "s *", message));
    System.out.println(starsToPrint);
    System.out.println(toPrint
        .map(Object::toString)
        .collect(Collectors.joining("\n")));
    System.out.println();
  }

  public static void main(String[] args) {
    var hub = new EventHub(new InMemoryEventRepository(), new InMemoryLocationRepository());
    printHelper("All Events", hub.listEvents().stream());
    printHelper("All Locations", hub.listLocations().stream());
    printHelper("First Two", hub.listEvents(c -> true, 2).stream());
    printHelper("First Four", hub.listEvents(c -> true, 4).stream());

    var dateFilter = new DateFilter(LocalDate.now());
    printHelper("Filter By Date", hub.listEvents(dateFilter, 2).stream());

    var fiveHundredDaysFromNowFilter = new DateFilter(LocalDate.now().plusDays(500));
    var distanceSort = new ManhattanDistanceComparator(hub, new Location("mine", 1, 1));
    printHelper(
        "Filter By Date Sorted By Location",
        hub.listEvents(fiveHundredDaysFromNowFilter, distanceSort, 10).stream());

    final Predicate<Event> nameFilter = e -> e.name.equals("kelly klarkson concert");
    printHelper(
        "Filter By Date Sorted By Location",
        hub.listEvents(nameFilter.and(dateFilter), distanceSort, 10).stream());

  }
}
