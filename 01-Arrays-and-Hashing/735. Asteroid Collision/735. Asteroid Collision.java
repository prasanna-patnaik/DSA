1class Solution {
2    public int[] asteroidCollision(int[] asteroids) {
3
4        Deque<Integer> stack = new ArrayDeque<>();
5
6        for (int asteroid : asteroids) {
7
8            boolean destroyed = false;
9
10            while (!stack.isEmpty()
11                    && stack.peek() > 0
12                    && asteroid < 0) {
13
14                int top = stack.peek();
15
16                if (top < -asteroid) {
17                    // Top asteroid explodes
18                    stack.pop();
19                }
20                else if (top == -asteroid) {
21                    // Both explode
22                    stack.pop();
23                    destroyed = true;
24                    break;
25                }
26                else {
27                    // Current asteroid explodes
28                    destroyed = true;
29                    break;
30                }
31            }
32
33            if (!destroyed) {
34                stack.push(asteroid);
35            }
36        }
37
38        int[] result = new int[stack.size()];
39
40        for (int i = result.length - 1; i >= 0; i--) {
41            result[i] = stack.pop();
42        }
43
44        return result;
45    }
46}