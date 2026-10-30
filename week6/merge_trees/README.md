## 1. Problem
We are given two binary trees, root1 and root2, and we need to merge them into one tree. If two nodes are in the same position in both trees (they overlap), the new node has the sum of their values. If only one of them exists in that position, we just use that one. The merging starts from the roots. If both trees are empty, the answer is null.

## 2. Approach
My approach is recursion again, because, as I said before, the tree is built from smaller trees, and merging two trees is the same as merging their roots and then merging their left subtrees and their right subtrees. I walk through both trees at the same time, always looking at two nodes that are in the same position. There are four cases. If both nodes are null, there is nothing to merge, so I return null. If only root1 is null, I return root2, and if only root2 is null, I return root1, because the rule says that the not null node is used. I don't need to go deeper in this case, because the whole subtree under that node has nothing to overlap with. If both nodes exist, they overlap, so I create a new node with the value root1.val + root2.val. Its left child is the result of merging the two left children, and its right child is the result of merging the two right children.

Example: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]. So in root1, 1 has children 3 and 2, and 3 has a left child 5. In root2, 2 has children 1 and 3, 1 has a right child 4, and 3 has a right child 7.
1) mergeTrees(1, 2): both exist, so merged = 1 + 2 = 3. Now we go left: mergeTrees(3, 1)
2) mergeTrees(3, 1): both exist, so merged = 3 + 1 = 4. Now we go left: mergeTrees(5, null)
3) mergeTrees(5, null): root2 is null, so we return node 5. We go back to 4
4) back to mergeTrees(3, 1): left is done (5). Now we go right: mergeTrees(null, 4)
5) mergeTrees(null, 4): root1 is null, so we return node 4. We go back to the node 4 that we made. It now has left 5 and right 4, and we go back to 3
6) back to mergeTrees(1, 2): the left side is done. Now we go right: mergeTrees(2, 3)
7) mergeTrees(2, 3): both exist, so merged = 2 + 3 = 5. Now we go left: mergeTrees(null, null)
8) mergeTrees(null, null): both are null, so we return null. We go back to 5
9) back to mergeTrees(2, 3): now we go right: mergeTrees(null, 7)
10) mergeTrees(null, 7): root1 is null, so we return node 7. We go back to the node 5. It now has left null and right 7, and we go back to 3
11) back to mergeTrees(1, 2): both sides are done, so we return the node 3
12) the tree is now [3,4,5,5,4,null,7], which is the expected output

Another example: root1 = [1], root2 = [1,2]. Both roots exist, so merged = 1 + 1 = 2. Left: mergeTrees(null, 2) returns node 2. Right: mergeTrees(null, null) returns null. The answer is [2,2].

If both roots are null, we return null right away.

At first I forgot about the cases where one of the nodes is null and I only wrote the case where both exist. The code crashed with a NullPointerException, because when one tree was shorter, I was calling root1.val on a null. That is why I added the checks for null at the very beginning.

## 3. Time Complexity
The time complexity of my solution is O(min(n, m)), where n and m are the numbers of nodes in the two trees. This is because we only go deeper while both nodes exist. As soon as one of them is null, we return and don't visit the rest. So in the worst case we visit as many nodes as the smaller tree has, and for each one we do a constant amount of work (one addition and creating one node).

## 4. Space Complexity
The space complexity is also O(min(n, m)). The new nodes that we create are part of the answer, and there can be up to min(n, m) of them, because we create a new node only where both trees have a node. On top of that, the recursion uses a call stack that is as deep as the shorter of the two trees' heights. In a balanced tree it is O(log n), but in the worst case, when the trees are long chains, the height is n, so it is O(n) in terms of the smaller tree.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity is again as good as it gets, because we have to look at every pair of overlapping nodes at least once to add their values. But, when I looked at leetcode, over 89% of solutions were better than me by a millisecond. There is definitely a better way to write the code. For space, I looked it up and you can do it without creating any new nodes by changing root1 directly: if both nodes exist, add root2.val to root1.val, and then continue with the children. That way the extra space is only the call stack, which is O(h), but it changes the input tree, and I wasn't sure if that is allowed, so I didn't go for it. Plus I am a little confused by this approach. You can also do it without recursion with a stack and a loop, but it would not be better in complexity, it would just be a different way to write it.