import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Point {
	int x,  y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Solution {
	
	static int dir[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static HashSet<Integer> all_dir = new HashSet<>();
	static int N, start_x, start_y, max_value, map[][]; 
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			max_value = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 4; i++)
				all_dir.add(i);
			
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					HashSet<Integer> save_num = new HashSet<>();
					start_x = x;
					start_y = y;
					DFS(start_x, start_y, 0, save_num); 
				}
			}
			
			sb.append("#" + test_case + " " + (max_value == 0 ? -1 : max_value) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(int x, int y, int cur_dir, HashSet<Integer> save_num) {
		
		// 디버깅 코드
//		System.out.println("x: " + x + ", y : " + y + ", : " + save_num.toString());
		
		if (start_x == x && start_y == y && cur_dir == 3) {

			int cur_total = save_num.size();
			
			if (cur_total > max_value)
				max_value = cur_total;
			//System.out.println(cur_total);
			return;
		}
		
		for (int i = cur_dir; i < Math.min(cur_dir+2, 4); i++) {
			
			int cur_x = x + dir[i][0];
			int cur_y = y + dir[i][1];
			
			if (is_In(cur_x, cur_y, save_num)) {
				if (!(cur_x == start_x && cur_y == start_y))
					visit[cur_x][cur_y] = true;
				save_num.add(map[cur_x][cur_y]);
				
				DFS(cur_x, cur_y, i, save_num);
				
				save_num.remove(map[cur_x][cur_y]);
				visit[cur_x][cur_y] = false;
			}
		}
		
	}
	
	public static boolean is_In(int x, int y, HashSet<Integer> save_num) {
		if (x >= 0 && y >= 0 && x < N && y < N && !save_num.contains(map[x][y])) {
			return true;
		}
			
		return false;
	}
}