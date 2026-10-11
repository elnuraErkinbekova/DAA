package week3_part2.palindrome_list;

import java.util.ArrayList;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int index = list.size() - 1;
        current = head;

        while (current != null) {
            if (current.val != list.get(index)) {
                return false;
            }
            current = current.next;
            index--;
        }

        return true;
    }
}
