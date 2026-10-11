package week3_part2.intersection;

import java.util.ArrayList;

public class IntersectionOf2Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> firstList = new ArrayList<>();

        ListNode currentA = headA;

        while (currentA != null) {
            firstList.add(currentA);
            currentA = currentA.next;
        }

        ListNode currentB = headB;

        while (currentB != null) {
            if (firstList.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.next;
        }

        return null;
    }
}