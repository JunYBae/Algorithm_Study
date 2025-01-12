import java.util.Scanner;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int T = sc.nextInt();
		int count = 0;
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int number = sc.nextInt();
			boolean is_prime = true;
			
			if(number <= 1)
				is_prime = false;
			
			for (int i = 2; i*i <= number; i++) {
				if(number % i == 0)
					is_prime = false;
			}
			

			if (is_prime)
				count++;
		}
		
		System.out.println(count);
	}
}