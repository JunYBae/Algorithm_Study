
import java.util.Scanner;

public class Main {
	
	static int left, right;
	static double count;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			left = sc.nextInt();
			right = sc.nextInt();
			
			double temp = 1;
			
			if (left == right) {
				System.out.println("1");
				continue;
			}
			
			for (int cur_right = right, i = 1; i <= left; cur_right--, i++) {
				temp *= cur_right;
			}
			
			//System.out.println(temp);
			
			for (int cur_left = left; cur_left > 0; cur_left--) {
				temp = temp / cur_left;
			}
			
			System.out.println(String.format("%.0f", temp));
		}
		
	}
	
}

