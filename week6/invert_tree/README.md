## 1. Problem
We are given the root of a binary tree and we need to invert it, which means that every node has to swap its left child and its right child. The tree can also be empty, then we return null.

## 2. Approach
My approach is recursion again, because, again, the tree is built from smaller trees (every node has a left subtree and right subtree that are also their own trees). Inverting the whole tree is the same as swapping the left and right child of every single node. So for every node I do this: swap its two children, and then call the same function on both of them, so their children get swapped too. The swap needs a temporary variable. I save the left child in "temporary", then put the right child into root.left, and then put "temporary" into root.right. The base case is if the node is null, then we return null, because there is nothing to swap. At the end I return root, because the root node itself stays the same, only its children change places.

Example: root = [4,2,7,1,3,6,9]. So 4 has children 2 and 7, 2 has children 1 and 3, and 7 has children 6 and 9.
1) invertTree(4): temporary = 2. Now 4.left = 7, 4.right = 2. So the tree under 4 is [4,7,2]. Then we call invertTree(7) for the new left
2) invertTree(7): temporary = 6. Now 7.left = 9, 7.right = 6. Then we call invertTree(9)
3) invertTree(9): both children are null. We swap null with null, nothing changes. Calls on null return right away. We go back to 7
4) back to invertTree(7): now we call invertTree(6), which is the same as 9, nothing changes. We go back to 4
5) back to invertTree(4): the left side is done, so now we call invertTree(2) for the new right
6) invertTree(2): temporary = 1. Now 2.left = 3, 2.right = 1. Then we call invertTree(3) and invertTree(1), both are leaves, nothing changes. We go back to 4
7) back to invertTree(4): both sides are done, so we return 4
8) the tree is now [4,7,2,9,6,3,1], which is the expected output

If the root is null (empty tree), we return null right away.

At first I tried to swap without the temporary variable, just by writing root.left = root.right and then root.right = root.left. It didn't work, because after the first line both children are the same node and the original left child is lost. That is why I need to save it in "temporary" first.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (the swap of two pointers).

## 4. Space Complexity
The space complexity is O(h), where h is the height of the tree. I don't create any new list or tree, the nodes are reused. The only memory that is used is the recursion call stack, which goes as deep as the longest path. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n, so it is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  It seems that there is no big improvement to be made, so I just looked at other answers in leetcode. My time complexity seems to be the best, but I could improve space complexity a little by using more complex code.