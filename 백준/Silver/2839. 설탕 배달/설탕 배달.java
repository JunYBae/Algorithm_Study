import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int count = 0;
		
		for (int five_kg = N/5; five_kg >= 0; five_kg--) {
			
			int remain = N - five_kg * 5;
			
			if (remain % 3 == 0) {
				count = five_kg + (remain / 3);
				System.out.println(count);
				return;
			}
			
			if (five_kg == 0) {
				System.out.println(-1);
				return;
			}
		}
		
		
	}
	


}