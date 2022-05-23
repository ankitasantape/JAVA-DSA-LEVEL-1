/*
 CLASS PRESIDENT
 
 The teacher does this by singing a song while walking around hte circle. 
 After the song is finished the student at which the teacher stopped is removed from the circle. 
 Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
 After the teacher is done singing, the next student is removed. The teacher repeats this until one student is left.
 A song of length k will result in the teacher walking past k students on each round. The students are numbered from 1 to n.
 The teacher starts at student 1.
 For example, suppose the song length is two(k=2). 
 And there are four students to start with (1,2,3,4). 
 The first student to go would be '2', after that '4', and after that '3'. Student '1' would be the next president in the example.
 
 *@param n the number of students sitting in a circle.
 *@param k the length (int student) of each song.
 *@return the number of the student that is elected.
 

*/


package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.ArrayList;
import java.util.List;

public class A24_Class_President {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		int ans = find_class_president(n, k);
		System.out.println(ans);
	}

	private static int find_class_president(int n, int k) {
		if( n == 1 ) {
			return 1;
		}
		List<Integer> list = new ArrayList<>();
		
		for( int i = 1; i <= n; i++ ) {
			list.add(i);
		}
		
		System.out.println(list);

		int idx = k-1;
		while( list.size() > 1 ) {
			
			if( idx >= list.size() ) {
				idx = idx % list.size();
			}
			System.out.println( list.remove(idx) );
			idx += (k-1);
		}
		
		return list.get(0);
	}

}
