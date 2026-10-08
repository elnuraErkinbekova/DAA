## 1. Problem
We are given two sorted linked lists. I need to merge them into one sorted list by "splicing together the nodes of the first two lists", basically reusing the nodes of these two lists.

## 2. Approach
My approach is that I used iteration and a dummy node (as a first node). The code compares the current nodes of the two lists and chooses the smaller one. I have a tail that will show what is the last node in the list for each iteration, so I don't just overwrite anything. The while loop stops when one of the two lists is run through. Then if the other list still has nodes, it just attaches them at the end of our new merged list. We can do that because the two lists are sorted. And at the end we just skip the dummy node. Basically, if the two lists are for example list1 = [1,1,2,3] and list2 = [1,2,3,4,5], then it will be like this: the 1 and 1 are compared, they are the same, so we just take the one from list1 (newlist=[1]). Now the list1's second 1 and list2's 1 that wasn't taken are compared, again we take from the list1 (newlist=[1,1]). Then list1's 2 and list2's 1 are compared, we take 1 (newlist=[1,1,1]). We go on. At the end, list1 finished faster and list2 is left with [3,4,5] that are just attached at the end and then we return dummy.next, which skips the dummy node and gives the actual first node (newlist=[1,1,1,2,2,3,3,4,5]).

## 3. Time Complexity
The time complexity of my solution is O(n+m). n and m are the lengths of the two given lists, since in the worst case scenario we go through both of them through start to finish

## 4. Space Complexity
The Space Complexity is O(1) because we only create one dummy node and only several pointers (tails and 2 lists). The nodes are reused, not copied, so there is no extra memory used.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I wasn't sure, so I kinda looked it up. It seems that O(n+m) and O(1) is as good as it gets. I really don't see other ways to solve it. I saw people also do recursive solution, but it is harder for me conceptually, plus it also doesn't seem to make it more optimal. I might be wrong, but I really don't know. The only improvement I can think of are just the way I write code, maybe I can make it shorter or more readable.