/*
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 
Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.


Sample Input

100
80
60
70
60
75
85

Sample Output
1
1
1
2
1
4
6
*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A15_Online_Stock_Span {

	static class StockSpanner {

		static class Pair {
			int stock;
			int index;
		}
		Stack<Pair> st;
		int time = 0; // array index

		public StockSpanner() {
			st = new Stack<>();
			Pair base = new Pair();
			base.stock = 1000000;
			base.index = -1;
			st.push(base);
		}

		public int next(int price) {
			Pair p = new Pair();
			p.stock = price;
			p.index = time;
			time++;
			
			while( st.peek().stock <= price ) {
				st.pop();
			}
			int ans = p.index - st.peek().index;
			st.push(p);
			return ans;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		StockSpanner obj = new StockSpanner();

		while (read.ready()) {
			int price = Integer.parseInt(read.readLine());
			System.out.println(obj.next(price));
		}
	}

}
