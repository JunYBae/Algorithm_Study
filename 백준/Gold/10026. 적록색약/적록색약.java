import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	
	static int N, map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int answer_1, answer_2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer_1 = 0;
		answer_2 = 0;
		
		for (int x = 0; x < N; x++) {
			StringBuilder temp = new StringBuilder(br.readLine());
			for (int y = 0; y < N; y++) {
				if(temp.charAt(y) == 'R') 
					map[x][y] = 1;
				else if (temp.charAt(y) == 'G')
					map[x][y] = 2;
				else if (temp.charAt(y) == 'B')
					map[x][y] = 3;
			}
		}
		
		boolean visit_1[][] = new boolean[N][N];
		boolean visit_2[][] = new boolean[N][N];
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visit_1[x][y]) {
					BFS(new Point(x, y), map[x][y], visit_1, false);
					answer_1++;
				}
				
				if (!visit_2[x][y]) {
					BFS(new Point(x, y), map[x][y], visit_2, true);
					answer_2++;
				}
			}
		}
		
		sb.append(answer_1).append(" ").append(answer_2);
		System.out.println(sb.toString());
	}
	
	public static void BFS(Point start, int first_color, boolean visit[][], boolean blind) {
		
		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		queue.add(start);
		visit[start.x][start.y] = true;
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			
			for (int index = 0; index < dir.length; index++) {
				
				int x = point.x + dir[index][0];
				int y = point.y + dir[index][1];
				
				if (is_In(x, y) && !visit[x][y]) {
					if (map[x][y] == first_color) {
						visit[x][y] = true;
						queue.add(new Point(x, y));
					}
					
					else if (blind && first_color <= 2 && map[x][y] <= 2) {
						visit[x][y] = true;
						queue.add(new Point(x, y));
					}
				}
			}
			
		}
		
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}













