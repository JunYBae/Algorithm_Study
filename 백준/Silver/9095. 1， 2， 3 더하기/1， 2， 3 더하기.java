import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int arr[] = {1, 2, 3};
	static int N, result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			result = 0;
			
			backTracking(0);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	
	public static void backTracking(int sum) {
		
		if(sum == N) {
			result++;
			return;
		} else if (sum > N) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			backTracking(sum + arr[i]);
		}
	}

}

