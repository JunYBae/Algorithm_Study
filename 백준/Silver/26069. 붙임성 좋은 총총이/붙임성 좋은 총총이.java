import java.util.*;

public class Main {
	
	static Set<String> set = new HashSet<>();
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++) 
		{
			String st[] = sc.nextLine().split(" ");
			
			if (st[0].equals("ChongChong") || st[1].equals("ChongChong")) {
				set.add(st[0]);
				set.add(st[1]);
			}
			
			else if (set.contains(st[0]) || set.contains(st[1])) {
				set.add(st[0]);
				set.add(st[1]);
			}
		}
		
		System.out.println(set.size());
	}
}
