## 1. Problem
We are given the root of a binary tree and we need to return a list of its values in inorder traversal. Inorder means that for every node we first visit everything in its left subtree, then the node itself, and only then everything in its right subtree. That's why it is "in order". The tree can also be empty, then we return an empty list.

## 2. Approach
My approach is recursion, because doing it without recursion was way more confusing in this case. The way it works is using the fact that the tree is built from smaller trees (every node has a left subtree and right subtree that are also their own trees). I have a list that is created once, and a helper function that gets the current node and this list. The helper does three things in this order: go to the left child, add the current node's value to the list, go to the right child. The base case is if the node is null, then we just return and do nothing. That is how we stop going deeper

Example: root = [1,null,2,3]. So 1 has no left child and its right child is 2, and 2 has a left child 3.
1) helper(1): the left is null, so helper(null) returns right away. Now we add 1. list = [1]. Then we go right: helper(2)
2) helper(2): we go left first: helper(3)
3) helper(3): the left is null, returns. We add 3. list = [1,3]. The right is null, returns. helper(3) is done, so we go back to helpler(2)
4) back to helper(2): left is done, so we add 2. list = [1,3,2]. The right is null, returns. helper(2) is done, so we go back to 1
5) back to helper(1): right is done too, so everything is finished
6) return [1,3,2]

If the root is null (empty tree), the helper returns right away and we return the empty list [].

My problem was that I first tried to do it without recursion, but it became too much of convoluted and big code, so I decided to do recursion. I think I got way better at understanding it, even if it takes me more time.
## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because every node is visited exactly once, and for each one we only do a constant amount of work (add to the list).

## 4. Space Complexity
The space complexity is also O(n), because I use array list and it holds all n values. On top of that, the recursion uses a call stack that is as deep as the height of the tree. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain (like [1,null,2,null,3...]), the height is n. So in total it is 2n which is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity O(n) is as good as it gets, because we need to visit every node at least once. I could avoid recursion by using a loop, but it would still be O(n) space in the worst case. Plus code would be way worse. I looked it up and there is something called Morris traversal that does something with the tree's pointers, so it doesn't need a stack at all. That makes the extra space O(1), but the code is much more complicated, so I didn't go for it.