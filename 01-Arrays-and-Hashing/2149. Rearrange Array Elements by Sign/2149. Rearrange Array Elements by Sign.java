1class Solution {
2    public int[] rearrangeArray(int[] nums) {
3        List<Integer> pos = new ArrayList<>();
4        List<Integer> neg = new ArrayList<>();
5        
6        // Separate positives and negatives
7        for (int num : nums) {
8            if (num > 0) {
9                pos.add(num);
10            } else {
11                neg.add(num);
12            }
13        }
14        
15        int[] ans = new int[nums.length];
16        int idx = 0;
17        
18        // Alternate: one positive, one negative
19        for (int i = 0; i < pos.size(); i++) {
20            ans[idx++] = pos.get(i);
21            ans[idx++] = neg.get(i);
22        }
23        
24        return ans;
25    }
26}