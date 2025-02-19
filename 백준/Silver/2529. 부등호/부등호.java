import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static String ch_list[];
	static int N, answer[];
	static boolean visit[], find;


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		ch_list = new String[N];
		answer = new int[N+1];
		visit = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			ch_list[i] = st.nextToken();
				
		find = false;
		
		for (int i = 9; i >= 0 && !find; i--) {
			visit[i] = true;
			answer[0] = i;
			find_big(1, i);
			visit[i] = false;
		}
		for (int i = 0; i < answer.length; i++)
			sb.append(answer[i]);
		sb.append("\n");
		
		Arrays.fill(visit, false);
		find = false;		
		
		for (int i = 0; i < 10 && !find; i++) {
			visit[i] = true;
			answer[0] = i;
			find_small(1, i);
			visit[i] = false;
		}
		for (int i = 0; i < answer.length; i++)
			sb.append(answer[i]);
		
		


		System.out.println(sb.toString());
	}

	public static void find_big(int vertex, int prev_num) {	
		
		if (find) // 최대 값 찾음
			return;
		
		if (vertex == N+1) {
			find = true;
			return;
		}
		
		for (int i = 9; i >= 0 && !find; i--) {
			
			if (!visit[i]) {
				switch(ch_list[vertex-1]) {
				case "<":
					if (prev_num < i) {
						answer[vertex] = i;
						visit[i] = true;
						find_big(vertex+1, i);
						visit[i] = false;
					} break;
					
				case ">":
					if (prev_num > i) {
						answer[vertex] = i;
						visit[i] = true;
						find_big(vertex+1, i);
						visit[i] = false;
					} break;
				}
			}
			
		}
	}
	
	public static void find_small(int vertex, int prev_num) {
		
		if (find) // 최소 값 찾음
			return;
		
		if (vertex == N+1) {
			find = true;
			return;
		}
		
		for (int i = 0; i <= 9 && !find; i++) {
			
			if (!visit[i]) {
				switch(ch_list[vertex-1]) {
				case "<":
					if (prev_num < i) {
						answer[vertex] = i;
						visit[i] = true;
						find_small(vertex+1, i);
						visit[i] = false;
					} break;
					
				case ">":
					if (prev_num > i) {
						answer[vertex] = i;
						visit[i] = true;
						find_small(vertex+1, i);
						visit[i] = false;
					} break;
				}
			}
			
		}
	}
}