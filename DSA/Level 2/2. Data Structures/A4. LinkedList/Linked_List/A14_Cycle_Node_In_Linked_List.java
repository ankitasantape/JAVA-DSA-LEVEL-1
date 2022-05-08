/*
1. Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
2. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

Notice that you should not modify the linked list.
Constraints
0 <= N <= 10^6
Sample Input
8
1
18
1
8
-1
138
31
84
3
Sample Output
8

Sample Input
145
175
73
131
34
62
194
167
122
20
108
152
3
175
89
132
66
41
65
24
23
173
59
107
163
142
62
117
145
12
22
82
153
76
90
47
119
10
42
0
155
150
190
43
81
136
186
69
64
33
54
190
96
0
89
179
44
101
165
137
152
13
189
185
76
19
4
116
37
72
151
108
149
126
130
132
57
166
105
5
9
76
60
70
100
12
174
88
129
140
7
147
154
182
84
128
11
152
0
5
177
137
149
14
85
58
83
54
63
182
17
153
175
120
105
157
111
8
116
197
5
49
199
121
189
18
110
142
34
47
141
133
61
59
198
51
86
180
20
93
199
43
86
61
89
127
-1
Sample Output
-1


*/

package Linked_List;

import java.util.Scanner;

public class A14_Cycle_Node_In_Linked_List {

	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode CycleNode(ListNode head) {
    	if( head == null || head.next == null ) {
			return head;
		}
        ListNode fast = head;
        ListNode slow = head;
        while ( fast.next != null && fast.next.next != null ) {
        	
        	fast = fast.next.next;
        	slow = slow.next;
        	
        	if( slow == fast ) {
        		break;
        	}
        }
        if( slow != fast ) {
        	return null;
        }
        
        slow = head;
        while( slow != fast ) {
        	slow = slow.next;
        	fast = fast.next;
        }
        
		return fast;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        ListNode ans = CycleNode(head);
        System.out.println(ans!=null?ans.val:-1);
    }
}
