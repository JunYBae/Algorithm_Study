import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[15][15];
		arr[0][1] = 1;
		
		for (int i = 1; i <= 14; i++) // 세로
			arr[i][1] = arr[i-1][1];
		
		for (int i = 2; i <= 14; i++) // 가로 누적합
			arr[0][i] = arr[0][i-1] + 1;
		
		for (int x = 1; x <= 14; x++) {
			for (int y = 2; y <= 14; y++) 
				arr[x][y] = arr[x-1][y] + arr[x][y-1]; 
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[k][n]);
		}
		
	}
}