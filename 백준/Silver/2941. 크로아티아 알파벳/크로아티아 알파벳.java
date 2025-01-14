import java.util.HashMap;
import java.util.Scanner;

class Main {
	
	static HashMap<String, Integer> hashmap = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		set_hashmap();
		
		int i = 0;
		int count = 0;
		
		while(i < st.length()) {
			
			if(i <= st.length() - 2 && hashmap.containsKey(st.substring(i, i+2))) {
				i += 2;
				count++;
			}
			
			else if (i <= st.length() - 3 && hashmap.containsKey(st.substring(i, i+3))) {
				i += 3;
				count++;
			}
			
			else  {
				i++;
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void set_hashmap() {
		hashmap.put("c=", 1);
		hashmap.put("c-", 1);
		hashmap.put("dz=", 1);
		hashmap.put("d-", 1);
		hashmap.put("lj", 1);
		hashmap.put("nj", 1);
		hashmap.put("s=", 1);
		hashmap.put("z=", 1);
	}
}