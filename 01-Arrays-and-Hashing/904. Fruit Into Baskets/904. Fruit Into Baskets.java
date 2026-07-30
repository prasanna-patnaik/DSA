1class Solution {
2    public int totalFruit(int[] fruits) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int left = 0;
5        int maxLength = 0;
6        
7        for (int right = 0; right < fruits.length; right++) {
8            // Add current fruit to basket
9            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
10            
11            // Shrink window while we have MORE than 2 types
12            while (map.size() > 2) {  // NOT == 2, but > 2!
13                map.put(fruits[left], map.get(fruits[left]) - 1);
14                if (map.get(fruits[left]) == 0) {
15                    map.remove(fruits[left]);
16                }
17                left++;
18            }
19            
20            // Update maxLength AFTER ensuring valid window
21            maxLength = Math.max(maxLength, right - left + 1);
22        }
23        
24        return maxLength;
25    }
26}