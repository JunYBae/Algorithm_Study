import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int N, M, arr[];
	static boolean visit[];
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생 수 
		M = Integer.parseInt(st.nextToken()); // 키 비교 횟수
		arr = new int[N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			map.get(last).add(first);
			arr[last]++;
		}
		
		for (int i = 1; i <= N; i++) {
			
			if(!visit[i]) { 
				DFS(i, sb);
			}
		}
		

		System.out.println(sb.toString());
	}
	
	public static void DFS (int vertex, StringBuilder sb) {
		
		ArrayList<Integer> list = map.get(vertex);
		
		for (int num : list) {
			if (!visit[num])
				DFS(num, sb);
		}
		
		if (!visit[vertex]) {
			sb.append(vertex).append(" ");
			visit[vertex] = true;
		}
	}
}













