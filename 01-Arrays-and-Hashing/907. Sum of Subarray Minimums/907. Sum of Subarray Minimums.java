1class Solution {
2    public int sumSubarrayMins(int[] arr) {
3
4        int n = arr.length;
5
6        int[] left = new int[n];
7        int[] right = new int[n];
8
9        Deque<Integer> stack = new ArrayDeque<>();
10
11        // Previous Smaller
12        for (int i = 0; i < n; i++) {
13
14            while (!stack.isEmpty()
15                    && arr[stack.peek()] > arr[i]) {
16
17                stack.pop();
18            }
19
20            if (stack.isEmpty()) {
21                left[i] = i + 1;
22            } else {
23                left[i] = i - stack.peek();
24            }
25
26            stack.push(i);
27        }
28
29        stack.clear();
30
31        // Next Smaller
32        for (int i = n - 1; i >= 0; i--) {
33
34            while (!stack.isEmpty()
35                    && arr[stack.peek()] >= arr[i]) {
36
37                stack.pop();
38            }
39
40            if (stack.isEmpty()) {
41                right[i] = n - i;
42            } else {
43                right[i] = stack.peek() - i;
44            }
45
46            stack.push(i);
47        }
48
49        long answer = 0;
50        int MOD = 1_000_000_007;
51
52        for (int i = 0; i < n; i++) {
53
54            long contribution =
55                    (long) arr[i] * left[i] * right[i];
56
57            answer = (answer + contribution) % MOD;
58        }
59
60        return (int) answer;
61    }
62}