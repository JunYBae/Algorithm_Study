import java.util.Scanner;

class Main {
	
	
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);
 		
 		int T = sc.nextInt();
 		int count = 0;
 		
 		for (int test_case = 1; test_case <= T; test_case++)
 		{
 			int array[] = new int[26];
 			boolean success = true;
 			String st = sc.next();
 			
 			char ch = st.charAt(0);
 			array[ch - 'a']++;
 			
 			for (int i = 1; i < st.length(); i++)
 			{
 				if (ch != st.charAt(i)) {
 					ch = st.charAt(i);
 					array[st.charAt(i) - 'a']++;
 				}
 			}
 			
 			
 			for (int i = 0; i < array.length; i++)
 			{
 				if (array[i] > 1)
 					success = false;
 			}
 			
 			if (success)
 				count++;
 			
 		}
 		
 		System.out.println(count);

 	}
}