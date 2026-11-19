## 1. Problem
We are given an integer array nums sorted in ascending order, and we need to convert it into BST. A height-balanced tree means the depth of the two subtrees of every node never differs by more than 1.

## 2. Approach
My approach is to use recursion with the divide and conquer method, similar to merge sort. Since the array is already sorted in ascending order, picking the middle element to be the root guarantees that half of the elements are smaller, so they go to the left and half are bigger, so they go to the right, which keeps the tree balanced.

Instead of slicing the array into new smaller arrays at every step, I use a helper function with two index pointers "left" and "right" to keep track of which part of the array we are working on. My base case is to return null when "left > right", because that means there are no elements left in that section. Otherwise, we calculate the middle index and create a new TreeNode with nums[mid]. Then we recursively build "root.left" using the left half of the array and "root.right" using the right half of the array. Finally we return root.

Example: nums = [-10, -3, 0, 5, 9]
1) Start with "left = 0" and "right = 4". "left <= right", so move on.
2) Calculate mid, it is = 2. nums[2] is 0, so we create root node 0.
3) Now we build 0's left side by calling "buildBST(nums, 0, 1)" (the [-10, -3] part)
4) left = 0, right = 1. Calculate mid, it is = 0. nums[0] is -10, so we create node -10.
5) Call left side of -10: "buildBST(nums, 0, -1)". Since "left > right" (0 > -1), it returns null.
6) Call right side of -10: "buildBST(nums, 1, 1)". mid = 1, nums[1] is -3, so we create node -3. Both of its left (1, 0) and right (2, 1) calls have "left > right", so they return null. Node -3 returns to -10, and -10 returns to root 0 as "root.left".
7) Okay, now that the left half is done, we build 0's right side by calling "buildBST(nums, 3, 4)" (the [5, 9] part):
8) left = 3, right = 4. Calculate mid, it is = 3. nums[3] is 5, so we create node 5.
9) Call left side of 5: "buildBST(nums, 3, 2)". Since "left > right" (3 > 2), it returns null.
10) Call right side of 5: "buildBST(nums, 4, 4)". mid = 4, nums[4] is 9, so we create node 9. Both of its left (4, 3) and right (5, 4) calls have "left > right", so they return null. Node 9 returns to 5, and 5 returns to root 0 as "root.right".
11) We went from the bottom or recursion all the way to the start. Root 0 returns the completed tree [0, -10, 5, null, -3, null, 9]. End.

I struggled more with syntaxis of writing this code than the idea of how it works. Other than that it wasn't hard.

## 3. Time Complexity
The time complexity of my solution is O(n) where n is the number of elements in the array. This is because we visit every single element in nums once to turn it into a TreeNode.

## 4. Space Complexity
The space complexity is O(log n). Because we always pick the middle element, the tree we build is guaranteed to be height-balanced, which means its height is log n. Each recursive call is placed on the call stack, so the stack goes at most log n levels deep.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  The time complexity cannot be improved beyond O(n) because we have to read every number in the array at least once to build the tree. For space complexity, O(log n) is already very efficient, so in this case I don't think I could improve it by replacing recursion with an iteration.