1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int n = nums.length;
4        int maxlength = 0;
5        int left = 0;
6
7        for (int right = 0; right < n; right++) {
8            // A zero ends the current sequence of ones
9            if (nums[right] == 0) {
10                int length = right - left;
11                maxlength = Math.max(maxlength, length);
12
13                // Start the next sequence after this zero
14                left = right + 1;
15            }
16        }
17
18        // Check the final sequence of ones
19        int length = n - left;  
20        maxlength = Math.max(maxlength, length);
21
22        return maxlength;
23    }
24}