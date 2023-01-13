class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode ans = null;
    var cur = head;
    var next = cur;

    while (next != null) {
      next = next.next;
      cur.next = ans;
      ans = cur;
      cur = next;
    }

    return ans;
  }

  public static void main(final String args[]) {
    final var solution = new ReverseLinkedList();
    assert solution.reverseList(
        new ListNode(1,
            new ListNode(2,
                new ListNode(3)))) == new ListNode(3,
                    new ListNode(2,
                        new ListNode(1)));
  }
}

// h
// 4>3>2>1>n n
// c
// n
// a
