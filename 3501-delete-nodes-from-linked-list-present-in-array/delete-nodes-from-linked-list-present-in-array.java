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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        // Convert int array to Set<Integer>
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        while (head != null) {
            if (!s.contains(head.val)) {
                t.next = head;
                t = t.next;
            }
            head = head.next;
        }
        
        t.next = null;
        return dummy.next;
    }
}