## 1. Problem
We are given a head of a linked list , and we need to sort it in ascending order.

## 2. Approach
My approach is basically reusing the code of the first task (sort an array) by creating an array with elements equal to nodes in a given linked list. And then I run the created array through the code I wrote for the first task. So what I do is count the number of nodes in a given linked list and then create an empty array with that number, so I can fit all the values of the linked list. Then I loop through the linked list and give all of its values to the array. Then I call sortList. I explained how it works in the previous README.md that is inside week5/sort_array. So this new code does the same with the given linked list that we converted to an array. I am leaving the tracing for [5,4,3,2,6] here as well, since I also used these values in my linked list example:

1) We divide it in half: [5,4] and [3,2,6]
2) Now we call merge(sortArray(left), sortArray(right))
3) merge(sortArray(left), sortArray(right)) works with sortArray(left) first. This does the following:
4) We divide [5,4] into [5] and [4]
5) Since they are length 1 (base case) they return themselves, so now we call merge([5], [4]) where we compare 5 and 4, see that 4 is smaller and return [4,5]
6) Okay, now that the left half is sorted, we work with sortArray(right):
7) [3,2,6] is divided into [3] and [2,6]
8) Now we work with [3] and since it is length 1, we just return [3]
9) Now we work with [2,6], divide them into [2] and [6]
10) Since they are length 1 (base case) they return themselves, so now we call merge([2], [6]) where we compare 2 and 6, see that 2 is smaller and return [2,6]
11) Now we compare [3] with [2,6]. We compare 3 to 2, determine that 2 is smaller, so we take it
12) Then we compare 3 to 6 and take 3
13) Left side is finished, so we just attach what is left: 6.
14) Now we have [4,5] and [2,3,6]
15) Compare 4 and 2, take 2
16) Compare 4 and 3, take 3
17) Compare 4 and 6, take 4
18) Compare 5 and 6, take 5
19) Left side is finished, so we just attach what is left, which is 6
20) Array is sorted, we now have [2,3,4,5,6]

And after we have a sorted array, we loop through a linked list from index 0 and give the nodes values of the sorted array. And that's how we end up with a sorted linked list.

I didn't really have trouble with this task, as I have basically done all the work in the previous task. But, a little unreleated, I did struggle with printing the linked list. Now I know how.

## 3. Time Complexity
The time complexity of my solution is still O(n log n). This is because I first count the nodes of the linked list, which takes O(n) time. Then I do the merge sort which takes O(n log n) time. Then I go through the linked list again to update its values with a sorted array, which takes O(n) time. In total I have O(n) + O(n log n) + O(n), which we simplify to O(n log n).

## 4. Space Complexity
The space complexity of my solution is still O(n). This is because as we saw it before, we already have space complexity of O(n) for creating left, right and result arrays at each level of recursion. On top of that we also create a temporary array to to hold all the values of the linked list, which also takes O(n) space. The result is 2n, but since we drop the constants, the space complexity is just O(n).
## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I saw that you can use pointers to sort a linked list instead of my very random approach, which would have space complexity of O(log n). So the way I can improve is being able to use more complicated code instead of very simplified and unsophisticated methods I usually use.