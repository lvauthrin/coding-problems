class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      // 4 step process
      // 1. Disconnect the tail
      // 2. Disconnect the head
      // 3. Reverse the middle
      // 4. Reconnect the head and tail

      var rNode = new ListNode(-1, head);

      for (int i = 0; i < right; i++) {
        rNode = rNode.next;
      }

      var tmp = rNode.next;
      rNode.next = null;
      rNode= tmp;

      var lNode = new ListNode(-1, head);

      for (int i = 0; i < left - 1; i++) {
        lNode = lNode.next;
      }

      var curr = lNode.next;
      var next = curr;
      var orig = curr;
      lNode.next = null;
      tmp = null;

      //   3>5>n    1,2
      //   h
      // l c n r
      //   o   t
      //.  3>n

      while (next != null) {
        next = next.next;
        curr.next = tmp;
        tmp = curr;
        curr = next;
      }

      lNode.next = tmp;
      orig.next = rNode;

      return left == 1 ? lNode.next : head;
    }
    
    public static void main(final String args[]) {
      final var solution = new ReverseLinkedListII();
      assert solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2) == new ListNode(2, new ListNode(1, new ListNode(3)));
    }
}
