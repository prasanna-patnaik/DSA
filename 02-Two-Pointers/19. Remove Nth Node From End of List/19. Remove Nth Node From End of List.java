1class Solution {
2    public ListNode removeNthFromEnd(ListNode head, int n) {
3
4        int length = 0;
5
6        ListNode temp = head;
7
8        while(temp != null){
9            length++;
10            temp = temp.next;
11        }
12
13        int need = length - n;
14
15        // Removing head
16        if(need == 0)
17            return head.next;
18
19        temp = head;
20
21        for(int i = 1; i < need; i++){
22            temp = temp.next;
23        }
24
25        temp.next = temp.next.next;
26
27        return head;
28    }
29}