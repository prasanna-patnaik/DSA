1class Solution {
2
3    public int[] searchRange(int[] nums, int target) {
4
5        int first = findFirst(nums, target);
6        int last = findLast(nums, target);
7
8        return new int[]{first, last};
9    }
10
11    private int findFirst(int[] nums, int target) {
12
13        int left = 0;
14        int right = nums.length - 1;
15        int ans = -1;
16
17        while (left <= right) {
18
19            int mid = left + (right - left) / 2;
20
21            if (nums[mid] == target) {
22                ans = mid;
23                right = mid - 1;   // keep searching left
24            }
25
26            else if (nums[mid] < target) {
27                left = mid + 1;
28            }
29
30            else {
31                right = mid - 1;
32            }
33        }
34
35        return ans;
36    }
37
38    private int findLast(int[] nums, int target) {
39
40        int left = 0;
41        int right = nums.length - 1;
42        int ans = -1;
43
44        while (left <= right) {
45
46            int mid = left + (right - left) / 2;
47
48            if (nums[mid] == target) {
49                ans = mid;
50                left = mid + 1;    // keep searching right
51            }
52
53            else if (nums[mid] < target) {
54                left = mid + 1;
55            }
56
57            else {
58                right = mid - 1;
59            }
60        }
61
62        return ans;
63    }
64}