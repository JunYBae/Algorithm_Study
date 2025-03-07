import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Edge {
	int vertex, cost;
	Edge(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Edge [vertex=" + vertex + ", cost=" + cost + "]";
	}
	
}

public class Main {
	
	static int N, M, answer;
	static boolean[] visited; // 방문 체크 배열
	static ArrayList<ArrayList<Edge>> edge_list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge_list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) 
			edge_list.add(new ArrayList<Edge>());
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edge_list.get(start).add(new Edge(end, cost));
			edge_list.get(end).add(new Edge(start, cost));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			
			answer = Integer.MAX_VALUE;
			visited = new boolean[N + 1]; // 방문 배열 초기화
			DFS(src, 0, dst);
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void DFS(int start, int cost, int end) {
		
		if (start == end) {
			if (answer > cost) 
				answer = cost;
			return;
		}
		
		for (Edge edge : edge_list.get(start)) 
			if(!visited[edge.vertex]) {
				visited[edge.vertex] = true;
				DFS(edge.vertex, cost + edge.cost, end);
				visited[edge.vertex] = false;
			}
	}
}


