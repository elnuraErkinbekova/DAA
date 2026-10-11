## 1. Problem
We are given the head of a sorted linked list. We need to return a new linked list with no duplicates.

## 2. Approach
My approach is creating a new linked list that has its head's value equal to the given head's value. And then we compare the old linked list's values with the new linked list's value one by one, and if the values don't match, then we store the value in a new node inside our new linked list. I'll show what I mean by going through my code and then showing it work with an example [1,1,1,2,3,3].

Code: First, we check if the list is empty (return the empty list if it is). Then, if it's not, we create new linked list = [(1, null)]. We also create a tail that points to the new linked list's head. We will need it to insert a new node in our new linked list. Then we also need a current of the old list, right now it is equal to head. Then we have a loop that goes on until we go through all values in the old linked list. First loop = see if the current is equal to the tail. It is, so we just make a current the next node in the old linked list. But our tail is the same. This is what happens if the values are equal. If they are not equal, before making current the next node, we first create new node with its value and attach it after tail and then set tail to this new node. At the very end we end up with a new linked list that we return. Now, let's see through an example

Example: [1,1,1,2,3,3]
tail = 1
old list current = 1
while old list is not null:
1 = 1 (they are same, so now: tail is still the same 1, old list current = 1 [this is a second 1, not the first 1])
1 = 1 (they are same, so now: tail is still the same 1, old list current = 1 [this is a third 1, not the second 1])
1 = 1 (they are same, so now: tail is still the same 1, old list current = 2)
1 != 2 (they are not the same, so now: insert 2 into new list, so it is now [1,2], tail = 2, old list current = 3)
2 != 3 (they are not the same, so now: insert 3 into new list, so it is now [1,2,3], tail = 3, old list current = 3 [this is the second 3, not the first 3])
3 = 3 (they are same, so now: tail is still the same 3, old list current = null)
The loop has ended because old list current is null. Now we just return the new linked list.

The reason this works is because the linked list is sorted, that's why there is no need for any extra sorting.

I have gone with this approach from the very start. The challenge was more in coding. It was easy to visualize the way algorithm works (I wrote the above example before I wrote code). But since I never worked with linked lists before, I needed to look at example code and cheat sheets to remember what words to use and how to, for example, actually store the nodes in a new linked lists. For example, I wrote "ListNode new_list_current = new_list;" instead of using tail in the while loop first. So it didn't work because I was just comparing with the first node instead of updating it.

## 3. Time Complexity
The time complexity of my solution is O(n), where n is the number of nodes. The reason is that it goes through the whole linked list in a linear way.

## 4. Space Complexity
The space complexity is also O(n), because in worst case scenario I create a node in the new linked list for every single node in the old linked list. Like if the given list is, for example, [1,2,3,4,5,6]

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
I saw before (not for this problem) that you can do something with next.next to just skip over unneeded nodes. So I think I probably didn't have to create whole other linked list and could just change my old one. So I think I could definitely improve on space complexity and make it O(1). I think the time complexity is as good as it can be.