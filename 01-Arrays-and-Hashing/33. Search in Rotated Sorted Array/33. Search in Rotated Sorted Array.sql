1class Solution {
2
3    public int search(int[] nums, int target) {
4
5        int n = nums.length;
6
7        // Step 1: Find pivot (index of minimum element)
8        int pivot = findPivot(nums);
9
10        // Array is not rotated
11        if (pivot == 0) {
12            return binarySearch(nums, target, 0, n - 1);
13        }
14
15        // Step 2: Decide which sorted half to search
16
17        // Left half: [0 ... pivot - 1]
18        if (target >= nums[0] && target <= nums[pivot - 1]) {
19            return binarySearch(nums, target, 0, pivot - 1);
20        }
21
22        // Right half: [pivot ... n - 1]
23        return binarySearch(nums, target, pivot, n - 1);
24    }
25
26    // Find index of minimum element
27    private int findPivot(int[] nums) {
28
29        int left = 0;
30        int right = nums.length - 1;
31
32        while (left < right) {
33
34            int mid = left + (right - left) / 2;
35
36            if (nums[mid] > nums[right]) {
37                // Minimum is on the right
38                left = mid + 1;
39            } else {
40                // Minimum is at mid or on the left
41                right = mid;
42            }
43        }
44
45        return left;
46    }
47
48    // Normal Binary Search
49    private int binarySearch(int[] nums, int target,
50                             int left, int right) {
51
52        while (left <= right) {
53
54            int mid = left + (right - left) / 2;
55
56            if (nums[mid] == target) {
57                return mid;
58            }
59
60            if (nums[mid] < target) {
61                left = mid + 1;
62            } else {
63                right = mid - 1;
64            }
65        }
66
67        return -1;
68    }
69}