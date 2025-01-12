import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	static String password;
	static char array[];
	static char answer[];
	static boolean visit[];
	static int pass_len, case_len;
	
	static char gather[] = {'a', 'e', 'i', 'o', 'u' };
	
	public static void main(String[] args) {
		
		pass_len = sc.nextInt();
		case_len = sc.nextInt();
		array = new char[case_len];
		visit = new boolean[case_len];
		answer = new char[pass_len];
		
		sc.nextLine();
		String temp = sc.nextLine();
		
		for (int i = 0; i < case_len + (case_len-1); i += 2)
		{
			array[i/2] = temp.charAt(i);
		}
		
		Arrays.sort(array);

		
		DFS(0, 0);
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (depth == pass_len) {
			check_password();
			return;
		}
		
		for (int i = vertex; i < case_len; i++) 
		{
			if(!visit[i])
			{
				visit[i] = true;
				answer[depth] = array[i]; 
				DFS(i, depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void check_password() {
		
		int gather_count = 0;
		int consonant_count = 0; 
		
		for (int i = 0; i < pass_len; i++)
		{
			boolean is_gather = false;
			for (int j = 0; j < gather.length; j++)
			{
				if (answer[i] == gather[j]) {
					gather_count++;
					is_gather = true;
					break;
				}
			}
			
			if(!is_gather)
				consonant_count++;
		}
		
		if (gather_count >= 1 && consonant_count >= 2) {
			for (int i = 0; i < pass_len; i++)
				System.out.print(answer[i]);
			System.out.println();
		}
	}
	
}





