import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int start, end;
	double cost;
	
	Edge(int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.cost, o.cost);
	}
}

public class Solution {
	
	static int N; // 섬 개수
	static double make_cost; // 환경 부담 세율
	static PriorityQueue<Edge> queue; // 우선순위 큐 
	static int island[]; // 사이클 여부 판단 배열 
	static double total_cost; 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			
			if (N == 1) {
				sb.append("#" + test_case + " " + 0 + "\n");
				continue;
			}
			
			ArrayList<Integer> x_list = new ArrayList<>(N+1); // x 리스트
			ArrayList<Integer> y_list = new ArrayList<>(N+1); // y 리스트 
			queue = new PriorityQueue<>();
			island = new int[N]; // 사이클 여부 판단 배열
			total_cost = 0; // 토탈 비용
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				x_list.add(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y_list.add(Integer.parseInt(st.nextToken()));
				island[i] = i;
			}
			
			make_cost = Double.parseDouble(br.readLine()); // 환경 부담 세율
			calculate_edge_cost(x_list, y_list); // edge 리스트 생성
			
			connect_island(); // 섬 연결 시작
			
			sb.append("#" + test_case + " " + Math.round(total_cost) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void connect_island() {
		
		int count = 0; // 섬 연결 개수
		
		while (count != N-1) { // 섬 연결 개수 - 1 = 간선 개수 -> 모든 섬 연결 
			
			Edge select_edge = queue.poll();
			
			int src_root = find_root(select_edge.start);
			int dst_root = find_root(select_edge.end);
			
			if (src_root == dst_root)
				continue;
			
			island[dst_root] = select_edge.start;
			total_cost += select_edge.cost; // 오버플로우 방지
			
			count++;
		}
		
	}
	
	// 우리 루트 친구를 찾아볼까?
	public static int find_root (int end) {
		
		int cur_island = end;
		
		while(cur_island != island[cur_island]) {
			cur_island = island[cur_island];
		}
		
		return cur_island;
	}
	
	
	public static void calculate_edge_cost(ArrayList<Integer> x_list, ArrayList<Integer> y_list) {
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double x_len = Math.abs(x_list.get(i) - x_list.get(j));
				double y_len = Math.abs(y_list.get(i) - y_list.get(j));
				double length = (x_len * x_len + y_len * y_len);
				
				queue.add(new Edge(i, j, length * make_cost));
			}
		}
		
	}
}







