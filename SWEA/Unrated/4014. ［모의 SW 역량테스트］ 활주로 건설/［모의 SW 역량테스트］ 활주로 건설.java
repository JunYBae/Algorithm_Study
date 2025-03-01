import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X, answer, map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 지형 맵 크기
			X = Integer.parseInt(st.nextToken()); // 경사로 길이
			map = new int[N][N]; // 맵
			answer = 0;
			
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x < N; x++) {
				if(simulation(map[x]))
					answer++;
				
				int temp[] = new int[N];
				
				for (int y = 0; y < N; y++)
					temp[y] = map[y][x];
				
				if(simulation(temp))
					answer++;
			}
					
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean simulation(int arr[]) {
		
		int prev = arr[0];
		int count = 0;
		
		for (int index = 0; index < arr.length; index++) {
			
			if (arr[index] == prev) {
				count++;
			}
			
			else if (prev < arr[index] && prev + 1 == arr[index]) {
				if (count < X) 
					return false;
				count = 1;
			}
			
			else if (prev > arr[index] && prev - 1 == arr[index]) {
				int w = 0;
				for (int t = index; t < Math.min(N, index+X); t++) {
					if (arr[index] != arr[t])
						return false;
					else
						w++;
				}
				
				if (w < X)
					return false;
				
				count = 0;
				index += X - 1;
			}
			
			else 
				return false;
	
			prev = arr[index];
		}
		
		return true;
	}
}

