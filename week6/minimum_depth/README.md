## 1. Problem
We are given the root of a binary tree and we need to return its minimum depth. Minimum depth is the number of nodes on the shortest path that starts at the root and goes down to the nearest leaf. A leaf is a node that has no children at all. So we count nodes, not edges. If the tree is empty, the depth is 0.

## 2. Approach
My approach is recursion again, because the tree is built from smaller trees, just like in the previous tasks. But this time it is not enough to just take my maximum depth code and swap Math.max for Math.min. The reason is the definition of a leaf: a node with only one child is not a leaf. So I have three cases. The base case is if the node is null, then the depth is 0. If the node has only one child (left is null or right is null), we ignore the missing side and only go down the side that exists, and add 1. If the node has both children, we find the depth of the left child, the depth of the right child, take the smaller one with Math.min and add 1.

Example: root = [2,null,3,null,4,null,5,null,6]. So every node has only a right child: 2 has right child 3 only, then 3 has right child 4 only, then 4 has right child 5 only, then 5 has right child 6 only.
1) minDepth(2): left is null, so we only go right: minDepth(3) + 1
2) minDepth(3): left is null, so we only go right: minDepth(4) + 1
3) minDepth(4): left is null, so we only go right: minDepth(5) + 1
4) minDepth(5): left is null, so we only go right: minDepth(6) + 1
5) minDepth(6): left is null, and right is null too. So we go right and call minDepth(null) which returns 0. 0 + 1 = 1. So 6 returns 1, and we go back to 5
6) back to minDepth(5): 1 + 1 = 2. Back to 4
7) back to minDepth(4): 2 + 1 = 3. Back to 3
8) back to minDepth(3): 3 + 1 = 4. Back to 2
9) back to minDepth(2): 4 + 1 = 5
10) return 5

Another example: root = [3,9,20,null,null,15,7]. 9 is a leaf, so it returns 1. Node 20 has two children (15 and 7) that are both leaves, so it returns min(1,1) + 1 = 2. Node 3 has both children, so min(1,2) + 1 = 2. The answer is 2.

If the root is null (empty tree), we return 0 right away.

At first I just copied my maxDepth code and changed Math.max to Math.min. It worked for the first example, but for the second example it returned 1 instead of 5. I figured out why: node 2 has no left child, so the left side returns 0, and Math.min picks that 0, so the code thinks the path ends at 2. But 2 is not a leaf, because it still has a right child. That is why I added the two cases that check if only one child is missing, so we only follow the side that actually exists.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. In the worst case (for example a chain like in the second example) we have to visit every node once, and for each one we only do a constant amount of work. Even when the tree is balanced, my code does not stop early, it still visits every node, so it is O(n).

## 4. Space Complexity
The space complexity is O(h), where h is the height of the tree. I don't store any list or array here, the only memory that is used is the recursion call stack, which goes as deep as the longest path. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [2,null,3,null,4...]), the height is n, so it is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity is O(n) in the worst case no matter what, but I looked it up and there is a way to do it faster in many cases: the first time we find a node with no children, we can stop right away and return its level, because it is guaranteed to be the closest leaf. My recursive code always goes through the whole tree even if there is a leaf right under the root. So the worst case is still O(n) time, but it often finishes much earlier. The space would be O(n) in the worst case, because the queue can hold a whole level of the tree at once, which is worse than my O(h) for a tall thin tree, but it can be better for a chain. So basically if we look at the worst case scenario, my code is okay, but often times the scenario isn't the worst and my code isnt really good for that.