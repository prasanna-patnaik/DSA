1class Solution {
2    public boolean check(int[] nums) {
3        int count = 0;
4        int n = nums.length;
5
6        // Normal adjacent check
7        for (int i = 0; i < n - 1; i++) {
8            if (nums[i] <= nums[i + 1]) {
9                continue;
10            } else {
11                count++;
12                if (count > 1) {
13                    return false;
14                }
15            }
16        }
17
18        // 🔥 Important: Circular check (last with first)
19        if (nums[n - 1] > nums[0]) {
20            count++;
21        }
22
23        return count <= 1;
24    }
25}