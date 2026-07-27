1class Solution {
2
3    public boolean isVowel(char c) {
4        return c == 'a' || c == 'e' || c == 'i' ||
5               c == 'o' || c == 'u';
6    }
7
8    public int maxVowels(String s, int k) {
9
10        int count = 0;
11
12        // Build first window
13        for (int i = 0; i < k; i++) {
14            if (isVowel(s.charAt(i))) {
15                count++;
16            }
17        }
18
19        int maxCount = count;
20
21        // Slide window
22        for (int i = k; i < s.length(); i++) {
23
24            // Remove left character
25            if (isVowel(s.charAt(i - k))) {
26                count--;
27            }
28
29            // Add right character
30            if (isVowel(s.charAt(i))) {
31                count++;
32            }
33
34            maxCount = Math.max(maxCount, count);
35        }
36
37        return maxCount;
38    }
39}