import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[10];
		for (int i = 0; i < 10; i++)
			arr[i] = 1;
		
		for (int i = 1; i < N; i++) {		
			int copy_arr[] = arr.clone();
			
			for (int index = 0; index < 10; index++) {
				
				int sum = 0;
				
				for (int j = index; j < 10; j++) {
					sum += copy_arr[j];
					sum = sum % 10007;
				}
				arr[index] = sum;
			}
		}
		
		int sum = 0;
		for (int index = 0; index < 10; index++) {
			sum += arr[index];
			sum = sum % 10007;
		}
		
		System.out.println(sum);
	}
}