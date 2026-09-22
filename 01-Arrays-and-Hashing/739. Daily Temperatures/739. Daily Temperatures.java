1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3
4        Deque<Integer> stack = new ArrayDeque<>();
5
6        int[] answer = new int[temperatures.length];
7
8        for (int i = 0; i < temperatures.length; i++) {
9
10            while (!stack.isEmpty()
11                    && temperatures[stack.peek()] < temperatures[i]) {
12
13                int element = stack.pop();
14
15                answer[element] = i - element;
16            }
17
18            stack.push(i);
19        }
20
21        return answer;
22    }
23}