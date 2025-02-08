import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int vertex, cost;
	
	Point(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Point other) {
		return Integer.compare(cost, other.cost);
	}
}

public class Main {
	
	static int V, E, start, cost[];
	static boolean visit[];
	static HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
	static PriorityQueue<Point> queue = new PriorityQueue<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		cost = new int[V+1];
		visit = new boolean[V+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // 시작
			int v = sc.nextInt(); // 도착
			int w = sc.nextInt(); // 가중치
			
			Point point = new Point(v, w);
			
			if (map.containsKey(u)) {
				ArrayList<Point> temp = map.get(u);
				temp.add(point);
			} else {
				ArrayList<Point> temp = new ArrayList<>();
				temp.add(point);
				map.put(u, temp);
			}
		}
		
		
		search_Route(new Point(start, 0));
		
		for (int i = 1; i <= V; i++) 
			System.out.println(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]);
		
	}
	
	public static void search_Route(Point start) {
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point cur = queue.poll();
			visit[cur.vertex] = true;
			ArrayList<Point> next_list = map.get(cur.vertex);
			
			if (next_list != null)
			{
				for (Point next : next_list) {
					int new_cost = cur.cost + next.cost;
					if (!visit[next.vertex] && new_cost < cost[next.vertex]) 
					{
						cost[next.vertex] = new_cost;
						queue.add(new Point(next.vertex, new_cost));
					}
					
				}
			}
			
			
		}
		
	}
}

