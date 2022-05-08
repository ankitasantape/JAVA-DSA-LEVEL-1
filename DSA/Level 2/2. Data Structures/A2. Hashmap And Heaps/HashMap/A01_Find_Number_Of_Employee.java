/* 
1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Output Format
Name of every employee and number of employees working under him.
Constraints
1 <= N <= 100
Sample Input
6
A C
B C
C F
D E
E F
F F
Sample Output
A 0
B 0
C 2
D 0
E 1
F 5

*/


package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A01_Find_Number_Of_Employee {

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //write your code here

        HashMap < String, String > empMan = new HashMap < > (); //emp -> man

        while (n-- > 0) {
            String emp = scn.next();
            String man = scn.next();

            empMan.put(emp, man);
        }

        //convert into generic tree
        HashMap < String, ArrayList < String >> gt = new HashMap < > ();
        String ceo = "";

        for (String emp: empMan.keySet()) {
            String man = empMan.get(emp);

            if (emp.equals(man) == true) {
                ceo = emp;
                ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
                gt.put(emp, list);
                continue;
            }

            ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
            list.add(emp);
            gt.put(man, list);

            ArrayList < String > list1 = gt.getOrDefault(emp, new ArrayList < > ());
            gt.put(emp, list1);
        }



        HashMap < String, Integer > ans = new HashMap < > ();
        getSize(ceo, gt, ans);


        for (String emp: ans.keySet()) {
            System.out.println(emp + " " + ans.get(emp));
        }
        scn.close();

    }


    public static int getSize(String node, HashMap < String, ArrayList < String >> gt, HashMap < String, Integer > ans) {
        int s = 0;

        for (String child: gt.get(node)) {
            s += getSize(child, gt, ans);
        }

        ans.put(node, s);
        return s + 1;

    }
}
