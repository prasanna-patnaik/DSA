1class Solution {
2
3    public void reorderList(ListNode head) {
4
5        if (head == null || head.next == null)
6            return;
7
8        // Find middle
9        ListNode slow = head;
10        ListNode fast = head;
11
12        while (fast.next != null && fast.next.next != null) {
13            slow = slow.next;
14            fast = fast.next.next;
15        }
16
17        // Reverse second half
18        ListNode second = reverse(slow.next);
19        slow.next = null;
20
21        // Merge two halves
22        ListNode first = head;
23
24        while (second != null) {
25
26            ListNode temp1 = first.next;
27            ListNode temp2 = second.next;
28
29            first.next = second;
30            second.next = temp1;
31
32            first = temp1;
33            second = temp2;
34        }
35    }
36
37    private ListNode reverse(ListNode head) {
38
39        ListNode prev = null;
40        ListNode curr = head;
41
42        while (curr != null) {
43
44            ListNode next = curr.next;
45
46            curr.next = prev;
47
48            prev = curr;
49            curr = next;
50        }
51
52        return prev;
53    }
54}