/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfLinkedList {
  public ListNode middleNode(ListNode head) {
    // m
    // [1,2,3,4,5,6]
    // e
    ListNode middle = head, end = head;

    while (end.next != null && end.next.next != null) {
      middle = middle.next;
      end = end.next.next;
    }

    return end.next != null ? middle.next : middle;
  }
}
