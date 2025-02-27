import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x, y, num;
	Point(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Solution {
	
	static int max_start, max_count, N, arr[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			max_count = 0;
			max_start = Integer.MAX_VALUE;
			
			for (int x = 0; x < N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++) 
					arr[x][y] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					backTracking(arr[x][y], new Point(x, y, arr[x][y]), 1);
				}
			}

			sb.append("#").append(test_case).append(" ").append(max_start)
			.append(" ").append(max_count).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int start, Point point, int length) {
		
		if (max_count == length) {
			if (max_start > start)
				max_start = start;
		}
		if (max_count < length) {
			max_count = length;
			max_start = start;	
		}
			
		
		for (int i = 0; i < dir.length; i++) {
			
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && point.num+1 == arr[x][y]) {
				backTracking(start, new Point(x,y, arr[x][y]), length+1);
			}
		}
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}

}
