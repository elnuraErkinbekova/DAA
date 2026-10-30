## 1. Problem
We are given the root of a binary tree and a number targetSum. We need to return true if there is a path from the root down to a leaf where the values of all nodes on the path add up to exactly targetSum, and false if there is no such path. If the tree is empty, there are no paths, so we return false.

## 2. Approach
My approach is to do it in the easiest way I could think of: first calculate the sum of every possible root-to-leaf path and save them in an array list, and then just loop through that list and compare each sum to targetSum. I use recursion for the first part. I have a helper function that gets the current node, the sum so far (currentSum) and the list. At the very start I just say that currentSum is 0 before we add any values. Every time we come to a node we add its value to currentSum. If the node is a leaf (no left and no right child), the path is finished, so we save currentSum in the list. If it is not a leaf, we go to the left child and then to the right child, passing the current sum with us. The base case is if the node is null, then we just return and do nothing. After all the sums are collected, a for loop checks if any of them is equal to targetSum. If yes, return true, if not, return false.

Example: root = [1,2,3], targetSum = 5. So 1 has a left child 2 and a right child 3.
1) collectSums(1, 0): currentSum = 0 + 1 = 1. 1 is not a leaf, so we go left first: collectSums(2, 1)
2) collectSums(2, 1): currentSum = 1 + 2 = 3. 2 is a leaf, so we save 3. allSums = [3]. We go back to 1
3) back to collectSums(1): left is done, so we go right: collectSums(3, 1)
4) collectSums(3, 1): currentSum = 1 + 3 = 4. 3 is a leaf, so we save 4. allSums = [3,4]. We go back to 1
5) back to collectSums(1): both sides are done, so the helper is finished
6) now the loop: 3 == 5? No. 4 == 5? No. The loop ends, so we return false

Another example: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22. The leaves are 7, 2, 13 and 1. The sums of the paths are 5+4+11+7 = 27, 5+4+11+2 = 22, 5+8+13 = 26 and 5+8+4+1 = 18. So allSums = [27,22,26,18]. When we loop, 27 is not 22, but the second one is 22, so we return true.

If the root is null (empty tree), the helper returns right away, the list stays empty, the loop does nothing and we return false.

I first wanted to do it the way where I would check inside the recursion, but I couldn't figure out how to keep track of the sum, so I decided to just save all the sums and compare after, which is much easier for me to understand, even if it is not efficient at all.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes in the tree. This is because we visit every node exactly once while collecting the sums, and for each one we only do a constant amount of work. Then the for loop goes through the list, which has one sum per leaf, and the number of leaves can't be more than n. So it is n + n = 2n, which is O(n).

## 4. Space Complexity
The space complexity is O(n), because I use an array list that holds one sum for every leaf. In a tree where almost every node is a leaf, that is close to n/2 numbers, which is O(n). On top of that, the recursion uses a call stack that is as deep as the height of the tree. In a balanced tree it is O(log n), but in the worst case, when the tree is just one long chain, the height is n. In both cases the total is O(n).

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  I think the time complexity O(n) is as good as it gets, because in the worst case we need to look at every node to be sure there is no path with the right sum. But the space can definitely be improved. I looked it up and instead of saving all the sums in a list, you can subtract each node's value from targetSum while going down, and at a leaf just check if what is left is equal to the value of that leaf. That way we don't need the list at all and the space is only O(h) for the call stack, which is O(log n) for a balanced tree. Also, with this approach we can stop as soon as we find one correct path (by using || between the left and right calls), while my code always goes through the whole tree and calculates all the sums even if the very first path was already the right one. So in the worst case my code is okay, but in many cases it does unnecessary work.