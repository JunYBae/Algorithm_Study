import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x, y;
	
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]\n";
	}
}


public class Solution {
	
	static int N, M, answer, map[][], cost[][];
	static ArrayList<Point> home_point;  // 홈 좌표 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 집이 지불할 수 있는 비용
			map = new int[N][N];
			cost = new int[N][N];
			answer = -Integer.MAX_VALUE;
			home_point = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1)
						home_point.add(new Point(i, j));
					map[i][j] = temp; 
				}
			}
			
			
			for (int range = 1; range <= N+5; range++) {	
				
				int range_cost_max = 0;
				int range_burst = 0;
				cost = new int[N][N];
				
				for (int home_num = 0; home_num < home_point.size(); home_num++) {
					ArrayList<Point> range_list = protect_range(home_point.get(home_num), range);
					range_burst = range_list.size();
					int cost_max = cost_and_max(range_list, range);
					
					if(cost_max > range_cost_max)
						range_cost_max = cost_max;
					
				}
				
//				System.out.println("range : " + range);
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++)
//						System.out.print(cost[i][j] + "\t");
//					System.out.println();
//				}
								
				int temp = range_cost_max * M - range_burst;
//				System.out.println("answer : " + answer + ", temp : " + temp);
				
				if (temp >= 0 && range_cost_max > answer)
					answer = range_cost_max;
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
	
	public static int cost_and_max(ArrayList<Point> point_list, int range) {
		
		int cost_max = 0;
		
		for (int i = 0; i < point_list.size(); i++) {
			Point point = point_list.get(i);
			
			if (is_In(point.x, point.y)) {
				cost[point.x][point.y]++;
				if (cost[point.x][point.y] > cost_max)
					cost_max = cost[point.x][point.y];
			}
		}
		
		return cost_max;
		
	}
	
	public static ArrayList<Point> protect_range(Point point, int range) {
		
		ArrayList<Point> range_list = new ArrayList<>(); 
		
		int x = point.x;
		int y = point.y;
		
		if (range == 1) {
			range_list.add(new Point(x, y));
			return range_list;
		}
		
		for (int i = range-1; Math.abs(i) <= range-1; i--) {
			for (int j = -(range - Math.abs(i) - 1); j < range - Math.abs(i); j++) {
				range_list.add(new Point(x-i, y-j));
			}
		}
		
		return range_list;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >=0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}

