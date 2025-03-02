import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	
	static int N, max;
	static int number[], answer[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		answer = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());
		
		
		DFS(0);
		sb.append(max);
		System.out.println(sb.toString());
	}
	
	public static void DFS(int vertex) {
		
		if (vertex == N) {
			int temp = calculate();
			if (temp > max)
				max = temp;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				answer[vertex] = number[i];
				visit[i] = true;
				DFS(vertex+1);
				visit[i] = false;
			}
		}		
	}
	
	public static int calculate() {
		
		int sum = 0;
		
		for (int i = 0; i < N-1; i++) {
			sum += Math.abs(answer[i] - answer[i+1]);
		}
		
		return sum;
	}
}

