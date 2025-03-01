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

public class Solution {
	
	static int K, N, max;
	static int answer;
	static int map[][];
	static boolean visit[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visit = new boolean[N][N]; // 방문 여부 확인
			max = 0;
			answer = 0;
			
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++) { 
					map[x][y] = Integer.parseInt(st.nextToken());
				
					if (map[x][y] > max) 
						max = map[x][y];
				}
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (max == map[x][y]) {
						visit = new boolean[N][N];
						visit[x][y]  = true;
						DFS(new Point(x, y), map[x][y], 1, false);
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void DFS(Point point, int height, int count, boolean is_break) {
		
		if (answer < count) {
			answer = count;
		}
		
		for (int i = 0; i < dir.length; i++) {
			
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && !visit[x][y]) {
				
				if (map[x][y] < height) {
					visit[x][y] = true;
					DFS(new Point(x, y), map[x][y], count+1, is_break);					
					visit[x][y] = false;
				}
				
				
				else if (!is_break && map[x][y] - K < height) {
					visit[x][y] = true;
					int temp = map[x][y] - height + 1;
					DFS(new Point(x, y), map[x][y]-temp, count+1, !is_break);
					visit[x][y] = false;
				}
			}
		}
		
	}
	
	public static boolean is_In (int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}







