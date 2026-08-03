1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length-1;
5        while(left <= right ){
6            int mid = left + (right-left)/2;
7
8            if(nums[mid] == target){
9                return mid;
10            }
11            else if(nums[mid] < target){
12                left = mid+1;
13            }
14            else{
15                right = mid-1;
16            }
17        }
18        return -1;
19    }
20}