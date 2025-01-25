
import java.util.Scanner;

public class Main {
	
	static int array[]; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		array = new int[T];
		
		for (int i = 0; i < T; i++)
			array[i] = sc.nextInt();
		
		int max_size = 0;
		int plus_size = 1;
		int minus_size = 1;
		// 증가 수열
		for (int index = 0; index < T-1; index++)
		{
			int cur_num = array[index];
			
			if (cur_num <= array[index+1])
				plus_size++;
			
			else {
				max_size = plus_size > max_size ? plus_size : max_size;
				plus_size = 1;
			}
			
			if (cur_num >= array[index+1])
				minus_size++;
			
			else {
				max_size = minus_size > max_size ? minus_size : max_size;
				minus_size = 1;
			}		
		}
		
		max_size = minus_size > max_size ? minus_size : max_size;
		max_size = plus_size > max_size ? plus_size : max_size;
		
		System.out.println(max_size);
		
	}
	
}
