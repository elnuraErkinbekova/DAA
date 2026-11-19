## 1. Problem
We are given the root of a BST and two integers, low and high. We need to find all the nodes whose values are between low and high (inclusive) and return the sum of their values.

## 2. Approach
My approach is to use recursion. My base case is to return 0 if root is null. Then I create a variable "currentValue" and set it to 0. We check if the current root's value is between low and high, includint the low and high. If it is, we make "currentValue" equal to "root.val". Then we check if "root.val < low". If it is, it means everything on the left side is even smaller than low, so there is no point checking left. That's why we only pass "root.right" into the function and return "currentValue + rightSum". Then we check if "root.val > high". If it is, everything on the right side is even bigger than high, so we skip right and only pass "root.left", returning "currentValue + leftSum". Otherwise, "root.val" is inside the range, which means valid nodes could be on both sides, so we pass both "root.left" and "root.right" and return "currentValue + leftSum + rightSum".

Example: root = [10,5,15,3,7,null,18], low = 7, high = 15
1) Start at root (10). Check if root == null. It's not, move on.
2) Check if 10 is between 7 and 15. It is, so "currentValue" becomes 10.
3) Check if 10 < 7 (no) or 10 > 15 (no). Since it's inside the range, we go to the "else" part and check both left and right sides.
4) First we go to the left side (5). Check if root == null. It's not, move on.
5) Check if 5 is between 7 and 15. It's not, so "currentValue" stays 0.
6) Check if 5 < 7. Since 5 < 7, we completely ignore 5's left side (3) and only pass 5's right child (7).
7) Now we are at 7. Check if 7 is between 7 and 15. It is, so "currentValue" becomes 7.
8) 7 is inside the range, so we check both its left and right children. Both are null, so both return 0. So node 7 returns "7 + 0 + 0 = 7" back to node 5.
9) Node 5 returns "0 + 7 = 7" back to root (10) as "leftSum".
10) Okay, now that the left half is done, we work with the right side of root (15). Check if root == null. It's not, move on.
11) Check if 15 is between 7 and 15. It is, so "currentValue" becomes 15.
12) 15 is inside the range, so we check both its left and right children. Its left child is null, so it returns 0.
13) Now we go to 15's right child (18). 18 is not between 7 and 15, so "currentValue" stays 0.
14) Check if 18 > 15. Since 18 > 15, we only pass 18's left child, which is null and returns 0. So node 18 returns "0 + 0 = 0" back to node 15.
15) Node 15 returns "15 + 0 + 0 = 15" back to root (10) as "rightSum".
16) Back at root (10), we add everything up: "10 + 7 + 15 = 32". We return 32. End.

At first I tried to solve this with iteration, because I thought it would take up less space. But I got confused, so I decided to use recursion. In recursion I tried to just have one sum and use a helper function to traverse BST and add values to the sum. But turns out Java works in a way that always leaves the original sum that I passed to helper function as 0. So I changed my approach and started instead updating a current value on each step of recursion and adding everything only at the end. I also improved my time complexity. Because at first I just checked every node in the BST. But then I realized that I could get rid of the subtrees whose roots were out of range.

## 3. Time Complexity
The time complexity of my solution is O(n) in the worst case, where n is the number of nodes in the BST. It can't be O(log n) because even though we skip branches that are out of range, if the given "[low, high]" range is huge and covers the whole tree, we can still end up visiting every single node. But on average it will probably be faster than O(n) because we cut out some parts of the tree.

## 4. Space Complexity
The space complexity is O(h) where h is the height of the tree, which is either equal to O(log n) for a balanced BST or O(n) for a skewed BST. This is because each recursive call is placed on the call stack.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
  The time complexity is already as good as it gets since we skip unnecessary nodes. Seems like in this problem we can't achieve O(log n) no matter what. But just like with searching a BST, I can improve the space complexity from O(h) to O(1). To do this, I would need to use iteration instead of recursion.
