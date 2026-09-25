## 1. Problem
    We are given an array with unique numbers in an ascending order and a target number. The task is to find the number equal to target number in our array, if we even have it. The index of the number if it exists, -1 if it doesn't.

## 2. Approach
    My approach is the simplest way that is definitely not the optimal solution at all: literally just to compare each number in an array from start to finish to the target number.

## 3. Time Complexity
    The time complexity of my solution is O(n) because it simply compares each number of the array to the target number. In best case, the first number of the array will match. In worst case, either there will be no matches or the match will be with the last number of the array.
    State the time complexity of your solution.

## 4. Space Complexity
   The Space Complexity is O(1) because every time it only works with i. It doesn't have to memorize anything else at the same time.

## 5. Reflection / Improvement
    - Is there a more efficient approach? What would you need to change?
    There definitely is. One way I think more efficient solution can be achieved is by comparing the middle of the array to the target. That way we can get rid of the half of the array. And then do the same to the left half, etc.

    - What complexity could the improved solution achieve?
    I know that this method of sorting has a name, but I don't know it. And I think it could have time complexity of O(log n) because, if for example the n is 16, it then becomes 8, then 4, then 2...
