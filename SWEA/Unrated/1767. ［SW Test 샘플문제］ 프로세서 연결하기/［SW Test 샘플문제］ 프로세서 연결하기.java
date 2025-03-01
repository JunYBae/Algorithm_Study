import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	
	static int N, connect, lines;
	static ArrayList<Point> processor;
	
	static int map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {			
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			connect = 0;
			lines = 0;
			processor = new ArrayList<Point>();
			
			for (int x = 0; x < N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++) { 
					map[x][y] = Integer.parseInt(st.nextToken());
					
					if (map[x][y] == 1 && x >= 1 && y >= 1 && x <= N-2 && y <= N-2) 
						processor.add(new Point(x, y));
				}
			}
	
			backTracking(0, 0, 0);		
			sb.append("#").append(test_case).append(" ").append(lines).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int vertex, int cur_pro, int cur_lines) {
		
		if (connect < cur_pro) {
			connect = cur_pro;
			lines = cur_lines;
		} else if (connect == cur_pro) {
			if (lines > cur_lines)
				lines = cur_lines;
		}
		
		if (vertex == processor.size())
			return;
		
		Point process = processor.get(vertex);
		
		for (int index = 0; index < dir.length; index++) {
			
			int step = 1;
			boolean success = true;
			
			while(true) {
				
				int x = process.x + dir[index][0] * step;
				int y = process.y + dir[index][1] * step;
				
				if (x < 0 || y < 0 || x >= N || y >= N)
					break;
				
				if (map[x][y] == 1) {
					success = false;
					break;
				}
					
				step++;
			}
			
			
			if (success) {
				connect_or_disable(process, index, true);
				backTracking(vertex+1, cur_pro+1, cur_lines+step-1);
				connect_or_disable(process, index, false);
			}
				
		}
		
		backTracking(vertex+1, cur_pro, cur_lines);
	}
	
	public static void connect_or_disable(Point point, int index, boolean is_connect) {
		
		int step = 1;
		
		while(true) {
			int x = point.x + dir[index][0] * step;
			int y = point.y + dir[index][1] * step;
			
			if (x < 0 || y < 0 || x >= N || y >= N)
				break;
			
			map[x][y] = is_connect ? 1 : 0;
			
			step++;
		}		
	}

}


