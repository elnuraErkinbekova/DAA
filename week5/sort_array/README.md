## 1. Problem
We are given an array of integers, and we need to sort it in ascending order.

## 2. Approach
My approach is using merge sort that we learned in class. It is recursive code that uses divide and conquer method. Basically u divide the given array in half. Then u do the same with new formed arrays over and over again until you are left with the sorted arrays in the form of one element, since if there is only one element in an array, it is sorted. This part is divide. Now we conquer by going up and sorting as we go. I will explain with and example I used in my code: [5,4,3,2,6]

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

The part I struggles with is understanding this part of code: return merge(sortArray(left), sortArray(right)). It was hard to understand what steps exactly the computer takes. Now I know that it first fully works with left side, then right side. So, first it works with [5,4]. Inside of it, it first works with 5, then 4. When it's done with the left side, it works with [3,2,6]. Inside of it, it first works with 3. When it's done with 3, it works with [2,6]. Inside of it, it first works with 2, then 6. After I got that part, everything went smoothly.

## 3. Time Complexity
The time complexity of my solution is O(n log n). This is because every time we call sortArray, we split the array in half, which creates a tree with a height of log n. But we also go through all the n elements every time we merge, that's why final Big O is n log n.

## 4. Space Complexity
The space complexity is O(n), because at each level of recursion we create left, right and result arrays, which grows in direct proportion to the size of the given array, which is n.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
While merge sort in itself seems to be the best approach, I ran through different ways to write the code for merge sort itself, and there are differences in milliseconds. For example, I didn't use java's copy array and ran a loop instead, which cost me 1-2 milliseconds