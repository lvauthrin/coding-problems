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
class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    var head = new ListNode(-1);
    var cursor = head;
    var minIndex = 0;

    while (minIndex != -1) {
      minIndex = -1;
      var nextVal = Integer.MAX_VALUE;

      for (int i = 0; i < lists.length; i++) {
        var pointer = lists[i];

        if (pointer != null && pointer.val < nextVal) {
          minIndex = i;
          nextVal = pointer.val;
        }
      }

      if (minIndex != -1) {
        cursor.next = lists[minIndex];
        cursor = cursor.next;
        lists[minIndex] = lists[minIndex].next;
      }
    }

    return head.next;
  }
}
/*
 * dummy->1
 * V
 * 4->5
 * V
 * 1->3->4
 * V
 * 2->6
 */
