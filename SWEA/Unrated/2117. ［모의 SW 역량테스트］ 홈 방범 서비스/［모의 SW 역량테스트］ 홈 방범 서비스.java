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
	
	static int N, M, answer, money; 
	static ArrayList<Point> home_list;
	static int map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			home_list = new ArrayList<Point>();
			answer = 0;
			money = 0;
			
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < N; y++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1)
						home_list.add(new Point(x, y));
				}
			}
			
			
			for (int index = 1; index <= N+10; index++) {
				map = new int[N][N];
				for (Point point : home_list)
					set_map(point, index);			
				calculate(map, index);
			}		
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void calculate(int map[][], int index) {
		
		int cost = index * index + (index - 1) * (index - 1);
		int max = 0;
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] > max)
					max = map[x][y];
			}
		}
		
		max *= M;
		int cal = max - cost;
		
		if (cal >= 0) {
			answer = max/M;
		}
	}
	
	public static void set_map(Point point, int index) {
		
		for (int x = -index+1; x <= index-1; x++) {
			for (int y = -index+1 + Math.abs(x); y < index-Math.abs(x); y++) {
				
				int cur_x = point.x + x;
				int cur_y = point.y + y;
				
				if(cur_x >= 0 && cur_y >= 0 && cur_x < N && cur_y < N)
					map[cur_x][cur_y]++;
				
			}		
		}
		
	}
	
	
}

