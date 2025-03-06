import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N, M, answer_1, answer_2, map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int remain_cheese;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		remain_cheese = 0;
		map = new int[N][M];
		
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < M; y++) { 
				map[x][y] = Integer.parseInt(st.nextToken());
				if(map[x][y] == 1)
					remain_cheese++;
			}
		}
		
		while(remain_cheese != 0) {
			
			answer_2 = remain_cheese;
			
			boolean visit[][] = new boolean[N][M];
			int copy_map[][] = new int[N][M];

			for (int x = 0; x < N; x++)
				copy_map[x] = map[x].clone();
				
			visit[0][0] = true;
			BFS(new Point(0, 0), visit, copy_map);
			
			answer_1++;
		}
		
		System.out.println(answer_1);
		System.out.println(answer_2);
	}
	
	public static void BFS(Point start, boolean visit[][], int copy_map[][]) {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int x = point.x + dir[i][0];
				int y = point.y + dir[i][1];
				
				if (is_In(x, y) && !visit[x][y]) {
					if (map[x][y] == 0) {
						visit[x][y] = true;
						queue.add(new Point(x, y));
					}
					
					else if (map[x][y] == 1) {
						visit[x][y] = true;
						copy_map[x][y] = 0;
						remain_cheese--;
					}
				}
			}
		}
		
		for (int x = 0; x < N; x++)
			map[x] = copy_map[x].clone();
	}
	
	public static boolean is_In(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}

