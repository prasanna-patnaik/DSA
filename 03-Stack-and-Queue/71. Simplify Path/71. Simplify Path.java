1class Solution {
2    public String simplifyPath(String path) {
3
4        Deque<String> stack = new ArrayDeque<>();
5
6        String[] parts = path.split(/);
7
8        for (String part : parts) {
9
10            if (part.equals() || part.equals(.)) {
11                continue;
12            }
13
14            if (part.equals(..)) {
15
16                if (!stack.isEmpty()) {
17                    stack.pop();
18                }
19
20            } else {
21                stack.push(part);
22            }
23        }
24
25        StringBuilder result = new StringBuilder();
26
27        while (!stack.isEmpty()) {
28            result.append(/).append(stack.removeLast());
29        }
30
31        return result.length() == 0 ? / : result.toString();
32    }
33}