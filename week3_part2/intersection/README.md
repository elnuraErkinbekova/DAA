## 1. Problem
We are given the heads of two linked lists. If the lists share a node (the same node in memory, not just the same value), we need to return that node. If they don't intersect, we return null. It also says that the lists must stay unchanged. The lists contain at least one node

## 2. Approach
My approach is pretty simple and very time consuming. I first store all the nodes of the list A in an array list. I then compare all the nodes in the array list to a node in the list B before moving on to the next node in the list B. So I take the first node in the list B and compare it to all the nodes in the array list. Then I take the second node in the list B and compare it to all the nodes in the array list. If there is a match, I return it. If there is no match, I return null.

Example: A = [1,2,3,5] and B = [4,2,3,5]. They meet at node 3.
So first, we create array list that is [1,2,3,5]
- CurrentB is 4, not null. Comparing 4 from list B to the whole array list that is [1,2,3,5]. No matches, make currentB = 2.
- CurrentB is 2, not null. Comparing 2 from list B to the whole array list that is [1,2,3,5]. No matches, make currentB = 3.
- CurrentB is 3, not null. Comparing 3 from list B to the whole array list that is [1,2,3,5]. There is match, return it.

If there were no matches, we would return null.

At first I didn't realize that the fact that the lists are different sized would create a problem, so I literally started comparing them from start to finish one by one. This of course wasn't accepted by the leetcode. So then I just went for brute force and did what I did. The easiness of my solution cost me all of the effciency I could have had.

## 3. Time Complexity
The time complexity of my solution is O(n*m). This is because in the worst case scenario for every single node in the list B we run the whole list A.

## 4. Space Complexity
The space complexity is O(m), because of the array list that is the whole size of list A. That's why I am saying O(m) and not O(n) because in the problem it is calling the number of nodes in the list A - m, and in the list B - n.

## 5. Reflection / Improvement
- Is there a more efficient approach? What would you need to change? What complexity could the improved solution achieve?
There is definitely a more efficient approach. To be honest, I didn't really think of one myself except for the fact that I could use something else instead of array list for better storage. But I looked at other solutions, and it seems you can just cut move the longer list by the difference between the two lists, because if one list is longer than the other, it is longer at the start. They are the same after the shared node. And the time complexity is O(m+n) because you go through both of the lists to count their size. And space complexity is O(1) because you do not store anything other than a few pointers.