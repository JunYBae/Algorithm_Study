
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	static int array[];
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = sc.nextInt();
		array = new int[count+1];
		
		for (int i = 1; i <= count; i++)
			array[i] = sc.nextInt();
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int gender = sc.nextInt();
			int switch_number = sc.nextInt();
			
			if (gender == 1)
			{
				for (int number = switch_number; number <= count; number += switch_number)
					array[number] = (array[number] + 1) % 2;
			}
			
			else 
			{	
				array[switch_number] = (array[switch_number] + 1) % 2;
				for (int number_left = switch_number-1, number_right = switch_number+1; 
						number_left >= 1 && number_right <= count && 
								array[number_left] == array[number_right]; 
						number_left--, number_right++) {
					array[number_left] = (array[number_left] + 1) % 2;
					array[number_right] = (array[number_right] + 1) % 2;
				}
					
			}
		}
		
		for (int i = 1; i < array.length; i++) {
			bw.write(array[i] + " ");
			if (i % 20 == 0)
				bw.newLine();
		}
		
		bw.flush();
	}
}
