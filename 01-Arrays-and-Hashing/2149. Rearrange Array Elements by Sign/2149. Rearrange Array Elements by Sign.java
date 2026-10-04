1class Solution {
2    public int[] rearrangeArray(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[n];
5        int posIndex = 0, negIndex = 1;
6        for (int i = 0; i < n; i++) {
7            if (nums[i] < 0) {
8                ans[negIndex] = nums[i];
9                negIndex += 2;
10            } else {
11                ans[posIndex] = nums[i];
12                posIndex += 2;
13            }
14        }
15        return ans;
16    }
17}