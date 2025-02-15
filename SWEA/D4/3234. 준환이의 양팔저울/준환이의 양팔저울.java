import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer, weight[];
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
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			backTracking(0, 0, 0);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int vertex, int left, int right) {
		
		if (vertex == N) {
			answer += 1;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				
				visit[i] = true;
				if (right + weight[i] <= left) 
					backTracking(vertex+1, left, right+weight[i]);
				visit[i] = false;
				
				visit[i] = true;
				backTracking(vertex+1, left+weight[i], right);
				visit[i] = false;
				
			}		
		}
	}
}





