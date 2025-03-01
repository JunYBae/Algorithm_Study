import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y, count;

	public Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}	
}


public class Solution {
	
	static int N, map[][];
	static boolean visit[][];
	static int max, max_num;
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0; max_num = 0;
			
			for (int x = 0; x < N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					visit = new boolean[N][N];
					visit[x][y] = true;
					DFS(x, y, map[x][y], map[x][y], 1);
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(max_num).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(int x, int y, int start, int cur_num, int count) {
		
		if (max < count) {
			max = count;
			max_num = start;
		}	
		else if (max == count) {
			if (start < max_num)
				max_num = start;
		}
			
		for (int index = 0; index < dir.length; index++) {
			
			int cur_x = x + dir[index][0];
			int cur_y = y + dir[index][1];
			
			if (is_In(cur_x, cur_y) && cur_num + 1 == map[cur_x][cur_y]) {
				visit[cur_x][cur_y] = true; 
				DFS(cur_x, cur_y, start, map[cur_x][cur_y], count+1);
				visit[cur_x][cur_y] = false;
			}
		}
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N && !visit[x][y])
			return true;
		return false;
	}
}
















