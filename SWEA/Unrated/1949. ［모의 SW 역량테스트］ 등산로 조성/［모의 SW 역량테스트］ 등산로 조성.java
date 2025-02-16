import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	static int N, K, answer, map[][];
	static boolean visit[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			K = Integer.parseInt(st.nextToken()); // 최대 공사할 수 있는 수
			
			map = new int[N][N]; // 맵 생성
			visit = new boolean[N][N]; // 방문 여부 확인
			int max_num = 0; // 젤 큰 숫자 저장할 변수 
			answer = 0; // 가장 긴 등산로
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					
					if (temp > max_num) // 젤 큰수 저장
						max_num = temp;
				}
			}
			
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (max_num == map[x][y]) {
						visit = new boolean[N][N];
						visit[x][y] = true;
						DFS(new Point(x, y), map[x][y], 1, false);
//						System.out.println("x : " + x + " y : " + y + " / " +  answer);
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 현재 x,y 와 현재 높이, 그리고 지금까지의 등산로 길이, 그리고 공사 했는지
	public static void DFS(Point point, int vertex, int count, boolean is_use) {
		
//		System.out.println("vertex : " + vertex + " , count : " + count);
		
		if (answer < count) { // 등산로 길이가 지금 까지 만든 것보다 길면?
			answer = count;
		}
		
		for (int i = 0; i < 4; i++) {
			
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && !visit[x][y]) {
				
				if (map[x][y] < vertex) { // 만약, 갈려는 곳이 현재보다 낮으면?
					visit[x][y] = true;
					DFS(new Point(x, y), map[x][y], count+1, is_use);
					visit[x][y] = false;
				}
				
				else if (!is_use && map[x][y] - K < vertex) { // 높이가 같거나 높은데 공사 횟수 남으면?
					visit[x][y] = true;
					int new_height = map[x][y] - vertex + 1;
					DFS(new Point(x, y), map[x][y] - new_height, count+1, !is_use);
					visit[x][y] = false;
				}	
			}
		}
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
	
}


