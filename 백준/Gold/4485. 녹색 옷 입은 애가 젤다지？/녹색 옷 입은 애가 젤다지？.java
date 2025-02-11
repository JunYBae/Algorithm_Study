import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y, cost;
	public Point(int x, int y, int cost) {
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
	
	static int N, map[][], answer[][];
	static int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;
		
		while((N = Integer.parseInt(br.readLine())) != 0) {
			
			map = new int[N][N];
			answer = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					answer[i][j] = Integer.MAX_VALUE;
				}
			}
			
			answer[0][0] = map[0][0];
			best_route();
			
			System.out.println("Problem " + (count++) + ": " + answer[N-1][N-1]);
		}
	}
	
	public static void best_route() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, map[0][0]));
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			if (map[point.x][point.y] == -1)
				continue;
			
			for (int i = 0; i < 4; i++) {
				int x = point.x + dir[i][0];
				int y = point.y + dir[i][1];
				
				if (x >= 0 && y >= 0 && x < N && y < N && map[x][y] != -1) {
					int new_route = point.cost + map[x][y];
					if (new_route < answer[x][y]) {
						queue.add(new Point(x, y, new_route));
						answer[x][y] = new_route;
					}
				}
				
			}
			
		}
	}
}

