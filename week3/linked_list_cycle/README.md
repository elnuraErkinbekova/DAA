## 1. Problem
    We are given head of linked list and need to determine if it has a cycle in it. Basically just the list in which the tail's next pointer is connected to a node inside the list. For example, if the last node in the list points at, say, the second node, then it means that the second node will eventually lead to the tail, which will lead to the second node, which will lead to tail... etc.

## 2. Approach
    My approach is that I have a "visited" array list that is empty at the start. Then, I go through every node in a list using while loop, and check if the current node is in my array list. If it is, then it means that I returned to this node, meaning that this list has a cycle (return true). And if the current node isn't in my array list, then we move it there. The loop ends either if we have found the node that tail is attached to (meaning that the list has cycle) or if the list is null (then it means that the list doesn't have a cycle). Example: head = [3,2,0,-4], pos = 1. Is 3 in the array list? No, so we add it and move to the next. Is 2 in the array list? No, add and move to the next. Is 0 in the array list? No, add and move to the next. Is -4 in the array list? No, add and move to the next. And the next is the 2. It is in the array list, so we return true.

## 3. Time Complexity
    The time complexity of my solution is O(n^2) because first of all in worst case scenario we go through all the nodes. But it is n^2 and not n because of "if (visited.contains(current))" becuase it needs to compare the current node in the loop with all the nodes stored in the "visited" array list.

## 4. Space Complexity
   The Space Complexity is O(n) because in the worst case scenario (which is no cycle, because then we go through all the nodes), we have to store the whole list in the "visited" array list.

## 5. Reflection / Improvement
    - Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
    While I do not know how exactly, I am sure there is a better way than to use array list and unnecessarily store everything there. My approach seems to be slow and also takes up space more than needed. I am sure if I found a way to not compare current to every single node in "visited" array list, it would be O(n) at the very list. Same goes for space complexity.