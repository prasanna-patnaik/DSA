1class Solution {
2
3    public ListNode reverseList(ListNode head) {
4
5        ListNode previous = null;
6        ListNode current = head;
7
8        while (current != null) {
9
10            ListNode next = current.next;
11
12            current.next = previous;
13
14            previous = current;
15
16            current = next;
17        }
18
19        return previous;
20    }
21}