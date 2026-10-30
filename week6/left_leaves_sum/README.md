## 1. Problem
We are given the root of a binary tree and we need to return the sum of all left leaves. A leaf is a node with no children at all, and a left leaf is a leaf that is the left child of its parent. So a leaf that is a right child does not count, and the root alone can never be a left leaf because it has no parent. If the tree is empty or has only the root, the answer is 0.

## 2. Approach
My approach is recursion again, because the tree is built from smaller trees. The tricky part is that a node can't know by itself if it is a left child, so I check from the parent's side. For every node I look at its left child and ask two things: does it exist, and does it have no children (left and right are both null)? If yes, then it is a left leaf and I add its value to sum. After that I still have to go deeper, so I add the answer for the whole left subtree and the answer for the whole right subtree. The base case is if the node is null, then the sum is 0, because there is nothing to count.

Example: root = [3,9,20,null,null,15,7]. So 3 has a left child 9 and a right child 20, and 20 has children 15 and 7.
1) sumOfLeftLeaves(3): sum = 0. The left child is 9, and it has no children, so it is a left leaf. sum = 9. Now we go left: sumOfLeftLeaves(9)
2) sumOfLeftLeaves(9): the left child is null, so nothing is added. Both recursive calls get null and return 0. So 9 returns 0, and we go back to 3
3) back to sumOfLeftLeaves(3): left side gave 0, so sum = 9 + 0 = 9. Now we go right: sumOfLeftLeaves(20)
4) sumOfLeftLeaves(20): sum = 0. The left child is 15, and it has no children, so it is a left leaf. sum = 15. Now we go left: sumOfLeftLeaves(15)
5) sumOfLeftLeaves(15): no children, so nothing is added and both calls return 0. So 15 returns 0, and we go back to 20
6) back to sumOfLeftLeaves(20): left side gave 0, so sum = 15. Now we go right: sumOfLeftLeaves(7)
7) sumOfLeftLeaves(7): no children, so it returns 0. Note that 7 is a leaf, but it is a right child, so nobody counted it. We go back to 20
8) back to sumOfLeftLeaves(20): sum = 15 + 0 = 15. So 20 returns 15, and we go back to 3
9) back to sumOfLeftLeaves(3): sum = 9 + 0 + 15 = 24
10) return 24

Another example: root = [1]. The left child is null, so nothing is added, both calls return 0, and the answer is 0.

If the root is null (empty tree), we return 0 right away.

I didn't really have a problem with that one, apart from visualizing how code works before writing it.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (a few null checks and maybe one addition).

## 4. Space Complexity
The space complexity is O(h), where h is the height of the tree. I don't create any list or array, the only memory that is used is the recursion call stack, which goes as deep as the longest path. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n, so it is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity O(n) and space complexity O(n) is again as good as it gets, but I could improve for not the worst case scenario definitely.