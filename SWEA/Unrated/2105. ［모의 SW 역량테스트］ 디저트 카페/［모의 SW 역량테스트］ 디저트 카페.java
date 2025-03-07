import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	static int N, answer, map[][];
	static int dir[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = -1;
			
			for (int x = 0; x < N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) 
					DFS(new Point(x, y), new Point(x, y), 0, new ArrayList<Integer>());
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(Point start, Point point, int direction, ArrayList<Integer> list) {
		
		if (direction == 3 && point.x == start.x && point.y == start.y) {
			if (answer < list.size()) 
				answer = list.size();
			return;
		}
		
		for (int i = direction; i <= Math.min(direction+1, 3); i++) {
			
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && !list.contains(map[x][y])) {
				list.add(map[x][y]);
				DFS(start, new Point(x, y), i, list);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static boolean is_In(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}

