
import java.util.Scanner;

public class Main {
	
	static int dp[] = new int[100];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
	
		int n = pibonachi(T);
		System.out.println(n);
	}
	
	public static int pibonachi(int number) {
		
		if (number == 0)
			return 0;
	
		if (dp[number] != 0)
			return dp[number];
		
		else {
			dp[number] = pibonachi(number-1) + pibonachi(number-2);
			return dp[number];
		}
		
	}
	
}



