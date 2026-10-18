package week5.sort_list;

public class MergeSort {

    public static void main(String[] args) {
        // Example linked list to test the code
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(6);

        head = sortList(head);

        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
        }
        System.out.println("]");
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int[] nums = new int[count];
        current = head;
        int index = 0;
        while (current != null) {
            nums[index++] = current.val;
            current = current.next;
        }

        nums = sortArray(nums);

        current = head;
        index = 0;
        while (current != null) {
            current.val = nums[index++];
            current = current.next;
        }

        return head;
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length < 2) return nums;
        int mid = nums.length / 2;

        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        for (int i = mid; i < nums.length; i++) {
            right[i - mid] = nums[i];
        }

        return merge(sortArray(left), sortArray(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, l = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[i] = left[l];
                l++;
            } else {
                result[i] = right[r];
                r++;
            }
            i++;
        }

        while (l < left.length) {
            result[i] = left[l];
            l++;
            i++;
        }

        while (r < right.length) {
            result[i] = right[r];
            r++;
            i++;
        }

        return result;
    }
}