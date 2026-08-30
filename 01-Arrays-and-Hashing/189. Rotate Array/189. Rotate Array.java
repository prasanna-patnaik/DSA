1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k % n;  // handle k > n
5        
6        // Reverse entire array
7        reverse(nums, 0, n - 1);
8        
9        // Reverse first k elements
10        reverse(nums, 0, k - 1);
11        
12        // Reverse remaining elements
13        reverse(nums, k, n - 1);
14    }
15    
16    private void reverse(int[] nums, int left, int right) {
17        while (left < right) {
18            int temp = nums[left];
19            nums[left] = nums[right];
20            nums[right] = temp;
21            left++;
22            right--;
23        }
24    }
25}