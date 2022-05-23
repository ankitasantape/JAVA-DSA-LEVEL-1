package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.*;


/*

Question 1:
Given a 2-D String array of student-marks find the student with the highest average and output his average score. If the average is in decimals, floor it down to the nearest integer.

Example 1:

Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
Output: 99
Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
Follow-up:
Questions: What is the time complexity? What is the space complexity? Can you solve it in O(n) time? 

*/

public class A19_Maximum_Average_Score {

	public static void main(String[] args) {
		  String[][] scores = {{"Bob","87"},{"Mike","35"},{"Bob","52"},{"Json","35"},{"Mike","55"},{"Jessica", "99"}};
		  
		  System.out.println( highestAverage(scores) );
	}
	
	public static int highestAverage(String[][] scores) {
		if( scores == null || scores.length == 0 ) {
			return -1;
		}
		int highestAvg = 0;
		
		HashMap<String, List<Integer>> map = new HashMap<>();
		  
		for(int i = 0; i < scores.length; i++) {
			String name = scores[i][0];
			List<Integer> scoreList = map.get(name);
			if( scoreList == null ) {
				List<Integer> currentScore = new ArrayList<>();
				currentScore.add(Integer.valueOf( scores[i][1] ));
				map.put(name, currentScore);
			}
			else {
				scoreList.add(Integer.valueOf( scores[i][1] ));
				map.put(name, scoreList);
			}
		}
		
		// go through the map. find the largest average
		for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			int currentAveScore = aveCalculate(entry.getValue());
			
			highestAvg = Math.max(currentAveScore, highestAvg);
		}
		return highestAvg;
	}
	
	private static int aveCalculate(List<Integer> scores) {
		int len = scores.size();
				
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		
		float ave = sum / len;
		return (int)ave;
	}

}
