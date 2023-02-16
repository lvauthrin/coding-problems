class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode first, ListNode second) {
    ListNode head = new ListNode();
    ListNode result = head;
    int carry = 0;

    while (first != null || second != null) {
      int firstValue = 0;
      int secondValue = 0;

      if (first != null) {
        firstValue = first.val;
        first = first.next;
      }

      if (second != null) {
        secondValue = second.val;
        second = second.next;
      }

      int total = (carry + firstValue + secondValue) % 10;
      carry = (carry + firstValue + secondValue) / 10;
      result.next = new ListNode(total);
      result = result.next;
    }

    if (carry > 0) {
      result.next = new ListNode(carry);
    }

    return head.next;

  }
}
