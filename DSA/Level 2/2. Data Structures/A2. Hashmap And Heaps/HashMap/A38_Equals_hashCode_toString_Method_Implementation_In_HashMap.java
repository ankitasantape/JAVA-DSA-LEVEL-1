package HashMap;

import java.util.HashMap;

public class A38_Equals_hashCode_toString_Method_Implementation_In_HashMap {
    
	static class Pair{
		int a;
		String str;
		
		Pair(){
			
		}
		Pair(int a, String str){
			this.a = a;
			this.str = str;
		}
		
		@Override
		public String toString() {
			return this.a + " " + this.str;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pair o = (Pair) (obj);
			
			if(this.a == o.a && this.str.equals(o.str) == true ) {
				return true;
			} 
			else {
				return false;
			}
		}
		@Override
		public int hashCode(){
			return this.a;
		}
		
	}
	public static void main(String[] args) {
		Pair p1 = new Pair(10, "abc");
		Pair p2 = new Pair(20, "pqr");
		Pair p3 = new Pair(10, "abc");
		Pair p4 = new Pair(20, "xyz");
		Pair p5 = new Pair(10, "abc");
	    Pair[] arr = new Pair[5];
	    arr[0] = p1;
	    arr[1] = p2;
	    arr[2] = p3;
	    arr[3] = p4;
	    arr[4] = p5;
	    
	    HashMap<Pair, Integer> map = new HashMap<>();
	    
	    if( p1.equals(p3) == true ) {
	    	System.out.println("yes");
	    }
	    
	    for(int i=0; i<arr.length; i++) {
	    	int nf = map.getOrDefault(arr[i], 0) + 1;
	    	map.put(arr[i], nf);
	    }
	    
	    System.out.println(map);
	    
        /*
         output: yes
                 {20 pqr=1, 20 xyz=1, 10 abc=3}
         */	    
	    
	}

}
