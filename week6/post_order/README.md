## 1. Problem
We are given the root of a binary tree and we need to return a list of its values in postorder traversal. Postorder means that for every node we first visit everything in its left subtree, then everything in its right subtree, and only at the end the node itself. That's why it is "post": the node comes after its subtrees. The tree can also be empty, then we return an empty list.

## 2. Approach
My approach is again the same as in my inorder and preorder traversal tasks. It is recursion again, because the tree is built from smaller trees (every node has a left subtree and right subtree that are also their own trees). I have a list that is created once, and a helper function that gets the current node and this list. The only difference is the order of the three steps. In inorder it was: go left, add the value, go right. In preorder it was: add the value, go left, go right. Here the helper does: go to the left child, go to the right child, and only then add the current node's value to the list. So I literally just moved the "add" line to the very end. The base case is the same too: if the node is null, we just return and do nothing. That is how we stop going deeper.

Example: root = [1,null,2,3]. So 1 has no left child and its right child is 2, and 2 has a left child 3.
1) helper(1): we go left first: helper(null) returns right away. Then we go right: helper(2). We don't add 1 yet
2) helper(2): we go left first: helper(3). We don't add 2 yet
3) helper(3): the left is null, returns. The right is null, returns. Now both sides are done, so we add 3. list = [3]. helper(3) is done, so we go back to helper(2)
4) back to helper(2): left is done. We go right: helper(null) returns right away. Now both sides are done, so we add 2. list = [3,2]. helper(2) is done, so we go back to helper(1)
5) back to helper(1): both sides are done, so now we add 1. list = [3,2,1]
6) return [3,2,1]

If the root is null (empty tree), the helper returns right away and we return the empty list [].

I didn't really have trouble with this task, because I already did inorder and preorder and the code is almost identical.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (add to the list).

## 4. Space Complexity
The space complexity is also O(n), because I use array list and it holds all n values. On top of that, the recursion uses a call stack that is as deep as the height of the tree. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n. So in total it is 2n which is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  It is the same as preorder and inorder where the time complexity O(n) is as good as it gets, but space complexity could be improved on in a lot of ways that don't use array list, like, as I talked about before, Morris traversal.