package week3_part2.remove_duplicates;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode new_list = new ListNode(head.val);
        ListNode tail = new_list;

        ListNode old_list_current = head;

        while (old_list_current != null) {
            if(old_list_current.val != tail.val) {
                tail.next = new ListNode(old_list_current.val);
                tail = tail.next;
            }
            old_list_current = old_list_current.next;
        }

        return new_list;
    }
}