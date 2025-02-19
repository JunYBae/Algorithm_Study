import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y, cost, break_wall;
	Point(int x, int y, int cost, int break_wall) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.break_wall = break_wall;
	}
}

public class Main {
	
	static int N, M, K, map[][];
	static int cost[][][];
	static boolean morning = true;
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cost = new int[N][M][K+1];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				Arrays.fill(cost[i][j], 1000000000);
			}
		}
		
		cost[0][0][0] = 1;
		int answer = simulation(new Point(0, 0, 1, 0));
		System.out.println(answer);
	}
	
	public static int simulation(Point start) {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				Point point = queue.poll();
				
//				System.out.println(point.x + ", " + point.y + " , " + cost[point.x][point.y][point.break_wall]);
				
				if (point.x == N-1 && point.y == M-1)
					return cost[point.x][point.y][point.break_wall];
				
				for (int index = 0; index < 4; index++) {
					
					int x = point.x + dir[index][0];
					int y = point.y + dir[index][1];
					
					if (is_In(x, y)) {
						
						if (map[x][y] == 0 && point.cost + 1 < cost[x][y][point.break_wall]) {
							cost[x][y][point.break_wall] = point.cost + 1;
							queue.add(new Point(x, y, point.cost + 1, point.break_wall));
						}
						
						else if (map[x][y] == 1 && point.break_wall < K) {
							if (morning) {
								if (point.cost + 1 < cost[x][y][point.break_wall+1]) {
								cost[x][y][point.break_wall+1] = point.cost + 1;
								queue.add(new Point(x, y, point.cost + 1, point.break_wall+1));
								}
							} else {
								queue.add(new Point(point.x, point.y, point.cost + 1, point.break_wall));
							}
						}
						

						
					}
				}
				
			} 
			
			
			morning = !morning;
		}
		return -1;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}

