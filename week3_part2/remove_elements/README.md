## 1. Problem
We are given the head of a linked list and a number "val". We need to remove all nodes whose value is equal to "val" and return the head of the new list. The list can be empty, and the head itself can be removed (for example, when all nodes have the value "val")

## 2. Approach
My approach is that I just skip over the nodes that are equal to "val". In previous tasks, I think I mentioned that I could do that to improve my code. Now I understood how to do it, so I am implementing that. What we do is basically see if the current in the loop is equal to val. If it is, we take previous node and make it point to the node after the current node (that's how we skip it). And that's why I have dummy node in my code, so we can have previous node for our head.

At first I tried "current = current.next.next" to skip a node, but turns out this only moves the pointer and does not change the list, so nothing was removed (I looked this up). It was also a little hard for me to get how to return the correct head, because I couldn't visualize it, so I literally just drew the process in my notebook. Now I get that u can use dummy.next, because while dummy is still there, the next node will always be the true head, because it either didn't change or the previous head got removed and dummy is now linked to the new head.

Example: list = [3,2,3,4,5]. val = 3
1) previous = dummy. current = 3. 3 == 3, so we remove it by doing this: "previous.next = current.next". so now dummy points at 2. previous is still dummy, current = 2
2) previous = dummy. current = 2. 2 != 3, so we keep it. now previous = 2. current = 3
3) previous = 2. current = 3. 3 == 3, so we remove it by doing this: "previous.next = current.next". so now 2 points at 4. previous is still 2, current = 4
4) previous = 2. current = 4. 4 != 3, so we keep it. now previous = 4. current = 5
5) previous = 4. current = 5. 5 != 3, so we keep it. now previous = 5. current = null

Since current == null, the loop ends. our dummy.next is the node 2, so we return it. List is now [2,4,5].

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes. Because I go through them from left to right once, and worst case scenario I remove every single node. But removing doesn't take significant time, so it is just O(n).

## 4. Space Complexity
The space complexity is also O(1), because I don't create much, just a dummy node and a few pointers. Unlike some of my solutions from other tasks, I did not create a new list or something here.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I think O(n) time complexity and O(1) space complexity is as good as you can do it. But maybe I could write a better code, just in terms of readability or something. I looked it up, and I could do recursive loop, but I have harder time with them.