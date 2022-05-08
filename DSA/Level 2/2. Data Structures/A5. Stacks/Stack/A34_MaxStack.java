/*
Description
Design a max stack that supports push, pop, top, peekMax and popMax.

1. push(x) -- Push element x onto stack.
2. pop() -- Remove the element on top of the stack and return it.
3. top() -- Get the element on the top.
4. peekMax() -- Retrieve the maximum element in the stack.
5. popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Contact me on wechat to get more FLAMG requent Interview questions . (wechat id : jiuzhang15)

-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
Constraints
1. There will be at least 1 element when pop, peek, popmax, peekmax is called.
Sample Input
push 5
push 1
push 5
top
popMax
top
peekMax
pop
top
Sample Output
5
5
1
5
1
5

Sample Input
push -2
popMax
push -45
push -82
push 29
pop
peekMax
push 40
pop
pop
push 66
peekMax
peekMax
push -61
peekMax
push 98
peekMax
Sample Output
-2
29
-45
40
-82
66
66
66
98
*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A34_MaxStack {
	  public  static class MaxStack {
			Stack<Integer> data;
			Stack<Integer> max;

			public MaxStack() {
				data = new Stack<>();
				max = new Stack<>();
			}

			public void push(int x) {
				if (max.size() == 0) {
					max.push(x);
				} else {
					if (max.peek() < x) {
						max.push(x);
					} else {
						max.push(max.peek());
					}
				}
				data.push(x);
			}

			public int pop() {
				max.pop();
				return data.pop();
			}

			public int top() {
				return data.peek();
			}

			public int peekMax() {
				return max.peek();
			}

			public int popMax() {
				int val = max.peek(); // to be removed

				Stack<Integer> buffer = new Stack<>();
				// O(n-1)
				while (data.peek() != val) {
					buffer.push(pop());
				}
				pop(); // O(1)
				// O(n-1)
				while (buffer.size() != 0) {
					push(buffer.pop());
				}
				return val;
			}

		}

		public static void main(String[] args) throws Exception {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

			MaxStack maxst = new MaxStack();

			while (read.ready()) {
				String[] inp = read.readLine().split(" ");

				switch (inp[0]) {
				case "pop":
					System.out.println(maxst.pop());
					break;
				case "top":
					System.out.println(maxst.top());
					break;
				case "popMax":
					System.out.println(maxst.popMax());
					break;
				case "peekMax":
					System.out.println(maxst.peekMax());
					break;
				case "push":
					maxst.push(Integer.parseInt(inp[1]));
					break;
				}

			}

		}
}
