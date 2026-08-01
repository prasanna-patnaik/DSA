1class Solution {
2    public String minWindow(String s, String t) {
3        if (s.length() < t.length()) return ;
4        
5        // STEP 1: Build frequency map for t
6        HashMap<Character, Integer> tMap = new HashMap<>();
7        for (char c : t.toCharArray()) {
8            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
9        }
10        
11        // STEP 2: Setup variables
12        HashMap<Character, Integer> windowMap = new HashMap<>();
13        int left = 0;
14        int minLen = Integer.MAX_VALUE;
15        int minStart = 0;
16        
17        // 🔥 KEY OPTIMIZATION: Use counters instead of HashMap comparison
18        int required = tMap.size();  // Number of unique chars needed
19        int matched = 0;             // Number of unique chars satisfied
20        
21        // STEP 3: Sliding window
22        for (int right = 0; right < s.length(); right++) {
23            char rightChar = s.charAt(right);
24            
25            // Expand window
26            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
27            
28            // 🔥 Check if this char's requirement is now satisfied
29            if (tMap.containsKey(rightChar) && 
30                windowMap.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
31                matched++;  // One more unique char satisfied!
32            }
33            
34            // 🔥 Shrink window while valid (O(1) check!)
35            while (matched == required) {
36                // Update minimum window
37                if (right - left + 1 < minLen) {
38                    minLen = right - left + 1;
39                    minStart = left;
40                }
41                
42                // Try to shrink from left
43                char leftChar = s.charAt(left);
44                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
45                
46                // 🔥 Check if removing this char breaks a requirement
47                if (tMap.containsKey(leftChar) && 
48                    windowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
49                    matched--;  // Lost one requirement!
50                }
51                
52                left++;
53            }
54        }
55        
56        return minLen == Integer.MAX_VALUE ?  : s.substring(minStart, minStart + minLen);
57    }
58}