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
	
	static int N, answer;
	static int map[][];
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
				for (int y = 0; y < N; y++) {
					backTracking(new Point(x, y), new Point(x, y), 0, new ArrayList<Integer>());
				}
			}
					
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void backTracking(Point point, Point start, int index, ArrayList<Integer> list) {
		
//		System.out.println(point.x + " " + point.y);
//		System.out.println(list.toString()); 		
		if (point.x == start.x && point.y == start.y && index == 3) {
			if (answer < list.size())
				answer = list.size();
			return;
		}
				
		for (int i = index; i <= Math.min(index+1, dir.length-1); i++) {			
			
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && !list.contains(map[x][y])) {
				list.add(map[x][y]);
				backTracking(new Point(x, y), start, i, list);
				list.remove(list.size() - 1);
			}
		}
		
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
	
}
