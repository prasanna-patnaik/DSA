1class Solution {
2    public int missingNumber(int[] nums) {
3        int mainsum = 0;
4        for(int i = 0;i<=nums.length;i++){
5            mainsum += i;
6        }
7        int sum = 0;
8        for(int i = 0;i<nums.length;i++){
9            sum += nums[i];
10        }
11        return mainsum-sum;
12    }
13
14}