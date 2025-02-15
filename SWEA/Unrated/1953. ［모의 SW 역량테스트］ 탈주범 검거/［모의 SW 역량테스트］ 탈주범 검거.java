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
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}

public class Solution {
	
	static int dir[][][] = {
			{},
			{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}, // 상,하,좌,우
			{{-1, 0}, {1, 0}}, // 상,하
			{{0, -1}, {0, 1}}, // 좌,우
			{{-1, 0}, {0, 1}}, // 상,우 
			{{1, 0}, {0, 1}},  // 하,우
			{{1, 0}, {0, -1}}, // 하,좌
			{{-1, 0}, {0, -1}} // 상,좌
			};
	
	static int N, M, R, C, L;
	static int answer;
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
			
			map = new int[N][M]; // 
			visit = new boolean[N][M]; // 방문 여부
			answer = 0;
			
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < M; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
			
			BFS(R, C);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void BFS(int start_x, int start_y) {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(start_x, start_y));
		
		int cur_time = 0; // 현재 시간
		int cur_count = 0; // 현재 파이프 개수 
		visit[start_x][start_y] = true; // 맨홀 위치 방문 true
		
		// 큐가 비었거나, 시간 다 되면 
		while(!queue.isEmpty() && !(cur_time == L)) {
			
//			System.out.println(queue.toString());
			
			int size = queue.size();
			cur_count += size;
			
			for (int i = 0; i < size; i++) {
				
				Point point = queue.poll();
				
				int cur_pipe = map[point.x][point.y]; // 무슨 파이프인지
				int pipe_list[][] = dir[cur_pipe]; // 해당하는 파이프 리스트 
				
				for (int index = 0; index < pipe_list.length; index++) {
					
					int cur_x = point.x + pipe_list[index][0];
					int cur_y = point.y + pipe_list[index][1];
					
					if (is_In(cur_x, cur_y) && is_connect(point.x, point.y, cur_x, cur_y)) {
						visit[cur_x][cur_y] = true;
						queue.add(new Point(cur_x, cur_y));
					}
					
				}
				
			}
			
			cur_time++;
		}
		
		answer = cur_count;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M && !visit[x][y] && map[x][y] != 0) 
			return true;
		return false;
	}
	
	public static boolean is_connect(int src_x, int src_y, int dst_x, int dst_y) {
		
		int dst_pipe_list[][] = dir[map[dst_x][dst_y]];
		ArrayList<String> dst_point = new ArrayList<>();
		
		for (int i = 0; i < dst_pipe_list.length; i++) {
			int x = dst_x + dst_pipe_list[i][0];
			int y = dst_y + dst_pipe_list[i][1];
			dst_point.add(x + " " + y);
		}
		
		for (String point : dst_point) {
			if (dst_point.contains(src_x + " " + src_y))
				return true;
		}
			
			return false;
	}
}



