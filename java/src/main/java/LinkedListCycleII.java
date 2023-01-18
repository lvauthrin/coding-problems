/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null)
      return null;

    ListNode first = head, second = head;
    // Find a node where there's a cycle
    ListNode cycleNode = null;

    while (second.next != null && second.next.next != null) {
      first = first.next;
      second = second.next.next;

      if (first.equals(second)) {
        cycleNode = first;
        break;
      }
    }

    if (cycleNode == null)
      return null;

    // Find cycle length
    first = head;
    second = cycleNode;

    while (first != second) {
      first = first.next;
      second = second.next;
    }

    return first;
    // o [3 2 0 -4]
    // f [2 0 -4 2 0 -4 2 0 -4 2 0 -4 2]
    // s [0 2 -4 0 2 -4 0 2 -4 0 2 -4 0]
    // o [1,2]
    // f [2 1]
    // s [1 1]
  }
}
