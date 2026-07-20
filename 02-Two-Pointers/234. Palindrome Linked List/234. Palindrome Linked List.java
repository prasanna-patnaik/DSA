1class Solution {
2
3    public boolean isPalindrome(ListNode head) {
4
5        if (head == null || head.next == null)
6            return true;
7
8        ListNode slow = head;
9        ListNode fast = head;
10
11        // Find end of first half
12        while (fast.next != null && fast.next.next != null) {
13            slow = slow.next;
14            fast = fast.next.next;
15        }
16
17        // Reverse second half
18        ListNode second = reverse(slow.next);
19
20        // Compare both halves
21        ListNode first = head;
22
23        while (second != null) {
24
25            if (first.val != second.val)
26                return false;
27
28            first = first.next;
29            second = second.next;
30        }
31
32        return true;
33    }
34
35    private ListNode reverse(ListNode head) {
36
37        ListNode previous = null;
38        ListNode current = head;
39
40        while (current != null) {
41
42            ListNode next = current.next;
43
44            current.next = previous;
45
46            previous = current;
47
48            current = next;
49        }
50
51        return previous;
52    }
53}