## 1. Problem
We are given the head of a linked list. We need to return true if it is palindrome (meaning it is the same if read through end to beginning) and false if it is not.

## 2. Approach
My approach is again brute force. I just store the linked list in an array list. Then I use indexes to access the array list from end to start and compare the last node of array list to the first node of linked list, then the second-to-last node of array list to the second node of linked list, etc... So I just basically flip the linked list and compare it to its normal version. If at any point, the values are not equal, I return false. Otherwise the loop ends and I return true.

Here is the example:
linked list = [1,2,3,2,1]
1) store the linked list in the array list. I now can use indexes.
2) start comparing. let's pretend that there are invisible letter marks on node so we can see visually. so now we have [1a,2b,3c,2d,1e]
3) 1a == 1e. next
4) 2b == 2d. next
5) 3c == 3c. next
6) 2d == 2b. next
7) 1e == 1a. current == null, so end
return true

## 3. Time Complexity
The time complexity of my solution is O(n), because we copy all the nodes to the array list, which is n steps. Then I walk through the list again and compare each node with a value from the array list, which is also n steps. So it is n + n = 2n, and constants are dropped, so it is O(n).

## 4. Space Complexity
The space complexity is O(n) because of the array list, it holds all the values, memory grows with the length of the list.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I definitely can improve. I think with nodes, time complexity O(n) is as good as it gets, but I definitely could figure out a way to not make space complexity O(n). I will be honest, I couldn't even think of the way to improve, so I looked it up and it seems you can find the middle, split the list into two, flip one of them and compare them. This make space complexity O(1).