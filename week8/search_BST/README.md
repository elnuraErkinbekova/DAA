## 1. Problem
We are given the root of BST and a target value. We need to search for node that is equal to the target value and return the subtree of that node. If such node does not exist, we need to return null.

## 2. Approach
My approach is to use recursion. My base case is to return null if root is null. Then we check if root's value (that is given to us) is equal to val (our target value). If it is equal, then we return the root. If it's not, we check if the root's value is smaller or bigger than val. If val is smaller, it means that it could be on the left side of the root. That's why we pass our function with the current root's left as the root. And if the value is bigger, than we pass the function with the current root's right as the root. And if we find nothing, it will return null.

Example: root = [4,2,7,1,3], val = 2
1) Check if root == null. It's not, move on.
2) Check if root.val == 2. It's not, move on.
3) Check if root.val > 2. 4 > 2, so we pass on 2 as root, since it is on the left of 4.
4) Check if root.val == 2. Since root.val is now 2, 2 == 2. We return 2. End.

I didn't struggle with this code because it was similar to the things we already did.

## 3. Time Complexity
The time complexity of my solution is O(h) where h is the height of the BST. It is either O(log n) if it is balanced BST or O(n) if it is skewed BST.

## 4. Space Complexity
The space complexity is also O(h) where h is the heigh of the tree, which is either equal to O(log n) for a balanced BST or O(n) for skewed BST. This is because each recursive call is placed on the call stack.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
The time complexity can't be improved, it will always be O(h). But I looked it up and turns out I can improve my space complexity from O(h) to O(1). To do this I need to use iteration instead of recursion.