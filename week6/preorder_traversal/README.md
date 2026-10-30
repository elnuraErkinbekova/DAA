## 1. Problem
We are given the root of a binary tree and we need to return a list of its values in preorder traversal. Preorder means that for every node we first visit the node itself, then everything in its left subtree, and only then everything in its right subtree. That's why it is "pre": the node comes before its subtrees. The tree can also be empty, then we return an empty list.

## 2. Approach
My approach is basically the same as in my inorder traversal task. It is recursion again, because the tree is built from smaller trees (every node has a left subtree and right subtree that are also their own trees). I have a list that is created once, and a helper function that gets the current node and this list. The only difference from inorder is the order of the three steps. In inorder it was: go left, add the value, go right. Here the helper does: add the current node's value to the list, go to the left child, go to the right child. So I literally just moved one line (the "add" line) from the middle to the top. The base case is the same too: if the node is null, we just return and do nothing. That is how we stop going deeper.

Example: root = [1,null,2,3]. So 1 has no left child and its right child is 2, and 2 has a left child 3.
1) helper(1): we add 1 right away. list = [1]. Then we go left: helper(null) returns right away. Then we go right: helper(2)
2) helper(2): we add 2. list = [1,2]. Then we go left: helper(3)
3) helper(3): we add 3. list = [1,2,3]. The left is null, returns. The right is null, returns. helper(3) is done, so we go back to helper(2)
4) back to helper(2): left is done. The right is null, returns. helper(2) is done, so we go back to helper(1)
5) back to helper(1): right is done too, so everything is finished
6) return [1,2,3]

If the root is null (empty tree), the helper returns right away and we return the empty list [].

I didn't really have trouble with this task, because I already did inorder and the code is almost identical.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (add to the list).

## 4. Space Complexity
The space complexity is also O(n), because I use array list and it holds all n values. On top of that, the recursion uses a call stack that is as deep as the height of the tree. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n. So in total it is 2n which is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I think that again, the time complexity O(n) is as good as it gets, because we need to visit every node at least once. It seems that I could again go for Morris traversal. Basically it is the same as inorder traversal.