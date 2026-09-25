## 1. Problem
    We are given an array that starts with 1 and goes up to n. One of this is the number for the first bad version of the product. We need to find it.

## 2. Approach
    My approach is again the simplest way that is definitely not the optimal solution at all: to use isBadVersion for every single array element from end to start. I made it from end to start because I feel like there is a higher chance that the bad version is close to the end.

## 3. Time Complexity
    The time complexity of my solution is O(n) because it simply goes through every element of the array. So the worst case is that it finds the first bad version at the very end of the loop.

## 4. Space Complexity
   The Space Complexity is O(1) because every time it only works with i and boolean isBadVersion. It doesn't have to memorize anything else at the same time.

## 5. Reflection / Improvement
    - Is there a more efficient approach? What would you need to change?
    There definitely is a more efficient approach. You can again find the middle element of the array and see if it is a bad version. If it's not, we eliminated the first half of the array already. And so on.

    - What complexity could the improved solution achieve?
    Since it is the same improvement as in the first task, I think it could have time complexity of O(log n) because, if for example the n is 16, it then becomes 8, then 4, then 2...
