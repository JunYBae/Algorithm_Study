import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer, total, weight[], factorial[], pow[];
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			visit = new boolean[N];
			answer = 0;
			total = 0;
			
	        // 팩토리얼 미리 계산
	        factorial = new int[10];  // N 최대 10 기준 (10!까지)
	        factorial[0] = 1;
	        for (int i = 1; i < 10; i++) {
	            factorial[i] = factorial[i - 1] * i;
	        }
	        
	        // 거듭제곱 미리 계산
	        pow = new int[10];
	        pow[0] = 1;
	        for (int i = 1; i < 10; i++) {
	        	pow[i] = pow[i-1] * 2;
	        }
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				total += weight[i]; 
			}

			
			backTracking(0, 0, 0);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int factorial(int N) {
		
		if (N == 1)
			return 1;
		return N * factorial(N-1);
		
	}
	
	
	public static void backTracking(int vertex, int left, int right) {
		
		if (vertex == N) {
			answer += 1;
			return;
		}
		
	    if (left > total / 2) {
	        answer += factorial[N - vertex] * pow[N - vertex]; // 남은 원소의 모든 경우를 곱함
	        return;
	    }
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				
				visit[i] = true;
				backTracking(vertex+1, left+weight[i], right);
				visit[i] = false;
				
				visit[i] = true;
				if (right + weight[i] <= left) 
					backTracking(vertex+1, left, right+weight[i]);
				visit[i] = false;
				

				
			}		
		}
	}
}





