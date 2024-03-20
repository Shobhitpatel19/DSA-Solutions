/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode prev = null;
        int i = 0;
        while (i < a) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode start = curr;
        while (i <= b) {
            curr = curr.next;
            i++;
        }
        ListNode end = curr;

        prev.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end;

        return list1;
    }
}