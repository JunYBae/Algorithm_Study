import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	
	static int M, N, K, arr[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 세로 
		N = Integer.parseInt(st.nextToken()); // 가로 
		K = Integer.parseInt(st.nextToken()); // 사각형 개수
		arr = new int[M][N];
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start_y = Integer.parseInt(st.nextToken());
			int start_x = Integer.parseInt(st.nextToken());
			int end_y  = Integer.parseInt(st.nextToken());
			int end_x  = Integer.parseInt(st.nextToken());
			
			for (int x = start_x; x < end_x; x++) {
				for (int y = start_y; y < end_y; y++)
					arr[x][y] = 1;
			}
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++)
				if (arr[x][y] == 0) {
					
					int temp = BFS(new Point(x, y));
					answer.add(temp);
				
				}
		}
		
		Collections.sort(answer);
		
		sb.append(answer.size()).append("\n");
		for (int num : answer)
			sb.append(num).append(" ");
		
		System.out.println(sb.toString());
	}
	
	
	public static int BFS(Point start) {
		
		int count = 0;
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(start);
		arr[start.x][start.y] = 1;
		
		while(!queue.isEmpty()) {
			
			count++;
			
			Point point = queue.poll();
			
			for (int index = 0; index < dir.length; index++) {
				
				int cur_x = point.x + dir[index][0];
				int cur_y = point.y + dir[index][1];
				
				if(is_In(cur_x, cur_y) && arr[cur_x][cur_y] == 0) {
					arr[cur_x][cur_y] = 1;
					queue.add(new Point(cur_x, cur_y));
				}
			}
		}
		
		return count;
	}
	
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		return false;
	}
}

