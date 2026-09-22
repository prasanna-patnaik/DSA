1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3
4        Deque<Integer> stack = new ArrayDeque<>();
5        Map<Integer, Integer> map = new HashMap<>();
6
7        for (int x : nums2) {
8
9            while (!stack.isEmpty() && stack.peek() < x) {
10                int element = stack.pop();
11                map.put(element, x);
12            }
13
14            stack.push(x);
15        }
16
17        int[] ans = new int[nums1.length];
18
19        for (int i = 0; i < nums1.length; i++) {
20            ans[i] = map.getOrDefault(nums1[i], -1);
21        }
22
23        return ans;
24    }
25}