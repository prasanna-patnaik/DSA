1class Solution {
2    public int search(int[] nums, int target) {
3
4        int left = 0;
5        int right = nums.length - 1;
6
7        while (left <= right) {
8
9            int mid = left + (right - left) / 2;
10
11            // Target found
12            if (nums[mid] == target) {
13                return mid;
14            }
15
16            // Left half is sorted
17            if (nums[left] <= nums[mid]) {
18
19                // Target lies inside sorted left half
20                if (nums[left] <= target && target < nums[mid]) {
21                    right = mid - 1;
22                }
23
24                // Target must be in right half
25                else {
26                    left = mid + 1;
27                }
28            }
29
30            // Right half is sorted
31            else {
32
33                // Target lies inside sorted right half
34                if (nums[mid] < target && target <= nums[right]) {
35                    left = mid + 1;
36                }
37
38                // Target must be in left half
39                else {
40                    right = mid - 1;
41                }
42            }
43        }
44
45        return -1;
46    }
47}