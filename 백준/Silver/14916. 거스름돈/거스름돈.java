import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[Math.max(N+1, 6)];
		Arrays.fill(arr, Integer.MAX_VALUE-1);
		
		arr[1] = arr[3] = -1;
		arr[2] = arr[5] = 1;
		arr[4] = 2;
		
		coin_calculate(5, arr, N);
		coin_calculate(2, arr, N);
		
		System.out.println(arr[N]);
	}
	
	public static void coin_calculate(int coin, int arr[], int N) {
		
		for (int index = coin+1; index <= N; index++) {
			
			if (arr[index-coin] == -1)
				continue;
			
			arr[index] = Math.min(arr[index-coin] + 1, arr[index]);
		}
		
	}
	
}