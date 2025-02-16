import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int x, y, break_wall;
	
	Point(int x, int y, int break_wall) {
		this.x = x;
		this.y = y;
		this.break_wall = break_wall;
	}
}

public class Main {

	static int N, M, map[][], cost[][][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		cost = new int[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				Arrays.fill(cost[i][j], 10000000);
				map[i][j] = str.charAt(j) - '0';
			}
		}
		

		
		cost[0][0][0] = 1;
		int answer = find_goal();
		System.out.println(answer);
	}
	
	
	public static int find_goal() {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0));
		
		while (!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			if (point.x == N-1 && point.y == M-1)
				return cost[point.x][point.y][point.break_wall];
			
			for (int i = 0; i < 4; i++) {
				
				int x = point.x + dir[i][0];
				int y = point.y + dir[i][1];
				
				if (is_In(x, y)) {
					// 벽 안부수기
					if (map[x][y] != 1 && cost[x][y][point.break_wall] > cost[point.x][point.y][point.break_wall] + 1) {
						cost[x][y][point.break_wall] = cost[point.x][point.y][point.break_wall] + 1;
						queue.add(new Point(x, y, point.break_wall));
					} 
					// 벽 부수기
					else if (map[x][y] == 1 && point.break_wall == 0 && 
							cost[x][y][point.break_wall+1] > cost[point.x][point.y][point.break_wall] + 1) { 
						cost[x][y][point.break_wall+1] = cost[point.x][point.y][point.break_wall] + 1;
						queue.add(new Point(x, y, 1));
					}
				}
			}
		}
		
		return - 1;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}





