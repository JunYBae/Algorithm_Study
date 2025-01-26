
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		double temp = 1;
		
		for (int cur_n = N, count = 1; count <= M; cur_n--, count++)
		{
			temp *= cur_n;
		}
		
		for (int cur_m = M; cur_m >= 1; cur_m--)
		{
			temp /= cur_m;
		}
		
		System.out.println(String.format("%.0f", temp));
	}
	

	
}
