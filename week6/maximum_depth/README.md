## 1. Problem
We are given the root of a binary tree and we need to return its maximum depth. Maximum depth is the number of nodes on the longest path that starts at the root and goes down to the farthest leaf. So we count nodes, not edges. If the tree is empty, the depth is 0.

## 2. Approach
My approach is recursion again. It works because, again, every node has a left subtree and a right subtree that are also their own trees. So the depth of any tree is just: the depth of the deeper subtree plus 1 for the current node. The base case is if the node is null, then the depth is 0, because there is nothing there to count. For every other node I find the depth of the left child, the depth of the right child, take the bigger one with Math.max and add 1.

Example: root = [3,9,20,null,null,15,7]. So 3 has a left child 9 and a right child 20, and 20 has children 15 and 7.
1) maxDepth(3): we need the left first, so we call maxDepth(9)
2) maxDepth(9): left is null, returns 0. Right is null, returns 0. max(0,0) + 1 = 1. So 9 returns 1, and we go back to 3
3) back to maxDepth(3): left = 1. Now we need the right, so we call maxDepth(20)
4) maxDepth(20): we go left first, maxDepth(15)
5) maxDepth(15): left and right are null, so 0 and 0. max(0,0) + 1 = 1. Back to 20
6) back to maxDepth(20): left = 1. Now we go right, maxDepth(7)
7) maxDepth(7): left and right are null, so 0 and 0. max(0,0) + 1 = 1. Back to 20
8) back to maxDepth(20): left = 1, right = 1. max(1,1) + 1 = 2. So 20 returns 2, and we go back to 3
9) back to maxDepth(3): left = 1, right = 2. max(1,2) + 1 = 3
10) return 3, as it is the biggest

If the root is null (empty tree), we return 0 right away.

At first I forgot the "+ 1" and my answer was always 0, because the only thing that was ever returned was the 0 from the null base case. Then I understood that the +1 is what actually counts the current node on the way back up. I also wasn't sure if the base case should return 0 or 1 for a null node. I checked with the tree [1,null,2]: if null gave 1, then even a leaf would give 2, which is wrong, so it has to be 0.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (compare two numbers and add 1).

## 4. Space Complexity
The space complexity is O(h), where h is the height of the tree. I don't store any list or array here, the only memory that is used is the recursion call stack, which goes as deep as the longest path. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n, so it is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity O(n) is as good as it gets, because we need to look at every node at least once to be sure we found the deepest one. I looked it up and you can also do it without recursion by using a queue and going level by level (BFS), counting how many levels there are. But it would still be O(n) time, and the queue can hold a whole level of the tree at once, so the space is O(n) in the worst case, which is not even better than mine. So I don't think there is a real improvement here, mostly just a different way to write it.