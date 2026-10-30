## 1. Problem
We are given the root of a binary tree and we need to return all root-to-leaf paths as strings, in any order. Each path is written with the values separated by "->", for example "1->2->5". A leaf is a node that has no children at all. If the tree has only the root, the answer is just that one value, like ["1"].

## 2. Approach
My approach is recursion again, and it is very close to my path sum task. In path sum I carried a number down the tree, and here I carry the path as a string. I have a list of strings that is created once, and a helper function that gets the current node, the path so far (currentPath) and the list. Every time we come to a node we add its value to currentPath. If the node is a leaf (no left and no right child), the path is finished, so we save currentPath in the list. If it is not a leaf, we add "->" to the path and go to the left child and then to the right child, passing the path with us. The base case is if the node is null, then we just return and do nothing.

Example: root = [1,2,3,null,5]. So 1 has a left child 2 and a right child 3, and 2 has only a right child 5.
1) helper(1, ""): currentPath = "1". 1 is not a leaf, so currentPath = "1->". We go left first: helper(2, "1->")
2) helper(2, "1->"): currentPath = "1->2". 2 is not a leaf (it has a right child), so currentPath = "1->2->". We go left: helper(null) returns right away. Then we go right: helper(5, "1->2->")
3) helper(5, "1->2->"): currentPath = "1->2->5". 5 is a leaf, so we save it. result = ["1->2->5"]. We go back to 2
4) back to helper(2): both sides are done, so we go back to 1
5) back to helper(1): the left side is done, so we go right: helper(3, "1->")
6) helper(3, "1->"): currentPath = "1->3". 3 is a leaf, so we save it. result = ["1->2->5","1->3"]. We go back to 1
7) back to helper(1): both sides are done, so everything is finished
8) return ["1->2->5","1->3"]

Another example: root = [1]. 1 is a leaf right away, so currentPath = "1" is saved and we return ["1"].

At first I wasn't sure how to add the "->" in the right places. If I added it after every value, then the finished paths would end with "->", like "1->2->5->", which is wrong. So I add the value first, check if it is a leaf, and only if it is not a leaf, I add "->" after it.

## 3. Time Complexity
The time complexity of my solution is O(n^2) in the worst case, where n is the number of nodes in the tree. We visit every node once, which is n steps, but for every node we make a new string by adding to the old one, and copying a string takes time proportional to its length. A path can be as long as n characters. The worst case is a tree that has a long chain of about n/2 nodes and then many leaves at the bottom, because then every leaf has a long path (about n/2) and there are about n/2 of them. So it is n/2 * n/2, which is O(n^2). In a balanced tree the paths are short (about log n), so it would be closer to O(n log n).

## 4. Space Complexity
The space complexity is O(n^2) in the worst case, because the result list stores all the finished paths. In the same example as above (a long chain with many leaves at the bottom), we have about n/2 paths and each of them is about n/2 long, so it is O(n^2). On top of that, the recursion uses a call stack that is as deep as the height of the tree, which is O(n) in the worst case of a chain, but that is smaller than the stored paths.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think I can improve it a little, but not in the worst case. I looked it up and instead of creating a new string at every step, you can use one StringBuilder, add the value when going down and remove it when going back (this is called backtracking). That way we don't copy the string for every node, only when we save a finished path. But I think the worst case is still O(n^2), because the answer itself can be that big (about n/2 paths that are each about n/2 long), and we have to write all of it down no matter what. So the improvement would mostly help in the normal cases and not in the worst one.