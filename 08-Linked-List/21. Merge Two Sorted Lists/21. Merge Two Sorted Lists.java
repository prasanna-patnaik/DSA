1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14
15class Solution {
16
17    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
18
19        // If one list is empty, return the other list.
20        if (list1 == null) return list2;
21        if (list2 == null) return list1;
22
23        // Dummy node helps avoid handling the first node separately.
24        ListNode dummy = new ListNode(-1);
25
26        // Current always points to the last node of the merged list.
27        ListNode current = dummy;
28
29        // Traverse both lists until one becomes null.
30        while (list1 != null && list2 != null) {
31
32            // Choose the smaller node.
33            if (list1.val <= list2.val) {
34
35                // Attach list1 node.
36                current.next = list1;
37
38                // Move list1 forward.
39                list1 = list1.next;
40
41            } else {
42
43                // Attach list2 node.
44                current.next = list2;
45
46                // Move list2 forward.
47                list2 = list2.next;
48            }
49
50            // Move current to the newly attached node.
51            current = current.next;
52        }
53
54        // Attach the remaining nodes.
55        // Only one of these lists can still have nodes.
56        if (list1 != null) {
57            current.next = list1;
58        } else {
59            current.next = list2;
60        }
61
62        // The merged list starts after the dummy node.
63        return dummy.next;
64    }
65}