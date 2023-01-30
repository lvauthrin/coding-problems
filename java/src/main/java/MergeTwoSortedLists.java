class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var min = new ListNode(-1);
    var head = min;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        min.next = list1;
        list1 = list1.next;
        min = min.next;
      } else {
        min.next = list2;
        list2 = list2.next;
        min = min.next;
      }
    }

    ListNode pointer;
    if (list1 == null)
      pointer = list2;
    else
      pointer = list1;

    while (pointer != null) {
      min.next = pointer;
      pointer = pointer.next;
      min = min.next;
    }

    return head.next;
  }
}
