import java.util.Scanner;

class Main {
	
	static long array[];
	static long sum;
	static long max;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			array = new long[sc.nextInt()];
			sum = 0;
			
			for (int i = 0; i < array.length; i++)
			{
				array[i] = sc.nextInt();
			}
			
			max = array[array.length-1];
			
			for (int i = array.length - 2; i >= 0; i--) 
			{
				if (array[i] < max)
				{
					sum += max - array[i];
				}
				else 
				{
					max = array[i];
				}
			}
			
			System.out.println(sum);
		}
	}
}