
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		long n = pactorial(T);
		System.out.println(n);

	}
	
	public static long pactorial(long number) {
		
		if (number == 1 || number == 0)
			return 1;
		
		else
			return number * pactorial(number - 1);

	}
	
}



