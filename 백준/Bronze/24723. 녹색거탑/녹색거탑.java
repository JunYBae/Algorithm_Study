
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 0;
		
		for (int count = 0; count <= N; count++)
		{
			int temp_1 = 1;
			int temp_2 = 1;
			
			for (int i = 0; i < count; i++)
			{
				temp_1 *= (N - i);
				temp_2 *= (i + 1);
			}
			
			result += temp_1 / temp_2;
		}
		
		System.out.println(result);
	}
}

 