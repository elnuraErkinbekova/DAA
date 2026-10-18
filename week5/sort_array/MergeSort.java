package week5.sort_array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // example array to test the code
        int[] array = new int[] {5,4,3,2,6};
        array = sortArray(array);
        System.out.println(Arrays.toString(array));
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
