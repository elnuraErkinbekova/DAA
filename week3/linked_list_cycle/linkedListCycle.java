package week3.linked_list_cycle;

import java.util.ArrayList;

public class linkedListCycle {
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> visited = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }
}