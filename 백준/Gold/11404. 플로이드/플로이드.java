import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int vertex, cost;
	Point(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Point o) {
		return Integer.compare(this.cost, o.cost);
	}
}

public class Main {
	
	static int V, E, cost[][];
	static HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		cost = new int[V+1][V+1];
		
		for (int i = 1; i <= V; i++)
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		
		for (int i = 1; i <= V; i++)
			cost[i][i] = 0;
		
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 출발
			int u = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			Point point = new Point(u, w); 
			
			if (map.containsKey(v)) {
				ArrayList<Point> temp = map.get(v);
				temp.add(point);
			} else {
				ArrayList<Point> temp = new ArrayList<>();
				temp.add(point);
				map.put(v, temp);
				}			
		}
		
		for (int i = 1; i <= V; i++) 
				search_plode(new Point(i, 0));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++)
				bw.write((cost[i][j] == Integer.MAX_VALUE ? "0" : cost[i][j]) + " ");
			bw.newLine();
		}
		
		bw.flush();
	}
	
	
	public static void search_plode(Point start) {
	
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			if(cost[start.vertex][point.vertex] < point.cost)
				continue;
			
			ArrayList<Point> next_node = map.get(point.vertex);		
			
			if (next_node != null) 
			{
				for (Point next_point : next_node) {
					
					// 현재 노드 -> 다음 노드 (신규) 
					int new_cost = cost[start.vertex][point.vertex] + next_point.cost;
					// 현재 노드 -> 다음노드 (기존)
					int prev_cost = cost[start.vertex][next_point.vertex];
					
					if(new_cost < prev_cost) {
						cost[start.vertex][next_point.vertex] = new_cost;
						queue.add(new Point(next_point.vertex, new_cost));
					}
				
				}
			}
			
		}
	}
}










