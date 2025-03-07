import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	
	static int N, list[];
	static boolean visit[];
	static ArrayList<Integer> answer_list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		list = new int[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		// 각 숫자마다 DFS
		for (int i = 1; i <= N; i++) {
			visit[i] = true;
			DFS(i, i);
			visit[i] = false;
		}
		
		sb.append(answer_list.size()).append("\n");
		for (int num : answer_list)
			sb.append(num).append("\n");
		System.out.println(sb.toString());
	}
	
	public static void DFS(int start, int end) {
		// 방문 여부 확인 
		if (!visit[list[start]]) {
			visit[list[start]] = true;
			DFS(list[start], end);
			visit[list[start]] = false;
		}
		// 사이클 형성시 넣어줌
		if (list[start] == end)
			answer_list.add(end);
	}
}

