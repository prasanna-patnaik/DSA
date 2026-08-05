1class Solution {
2    public int findPeakElement(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left < right) {
7
8            int mid = left + (right - left) / 2;
9
10            if (nums[mid] < nums[mid + 1]) {
11                left = mid + 1;
12            } else {
13                right = mid;
14            }
15        }
16
17        return left;
18    }
19}