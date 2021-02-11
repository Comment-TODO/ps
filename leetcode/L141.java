/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class L141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        
        return false;
    }
}
