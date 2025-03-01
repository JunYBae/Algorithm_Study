import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y, cost;

	public Point(int x, int y, int cost) {
		super();
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(this.cost, o.cost);
	}
	
}


public class Main {
	
	static int T, map[][], cost[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = 1;

		while((T = Integer.parseInt(br.readLine()))!= 0) {
			
			map = new int[T][T];
			cost = new int[T][T];
			for (int x = 0; x < T; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				Arrays.fill(cost[x], Integer.MAX_VALUE);
				for (int y = 0; y < T; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
		
			cost[0][0] = map[0][0];
			int answer = BFS(new Point(0, 0, cost[0][0]));
			
			sb.append("Problem ").append(test_case).append(": ").append(answer).append("\n");
			test_case++;
		}
		System.out.println(sb.toString());
	}
	
	public static int BFS(Point start) {
		
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			if (point.x == T-1 && point.y == T-1)
				return point.cost;
			
			for (int index = 0; index < 4; index++) {
				int x = point.x + dir[index][0];
				int y = point.y + dir[index][1];
				
				if (x >= 0 && y >= 0 && x < T && y < T && cost[x][y] > point.cost + map[x][y]) {
					cost[x][y] = point.cost + map[x][y];
					queue.add(new Point(x, y, cost[x][y]));
				}
			}			
		}
		
		return -1;
	}
}



