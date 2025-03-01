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

	static int N, M, R, C, L, answer;
	static int map[][];
	static boolean visit[][];
	static int dir[][][] = { 
			{}, 
			{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}, 
			{{1, 0}, { -1, 0}},
			{{0, -1}, {0, 1}}, 
			{{-1, 0}, {0, 1}}, 
			{{1, 0}, {0, 1}}, 
			{{1, 0}, { 0, -1}},
			{{-1, 0}, {0, -1}} 
	};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			R = Integer.parseInt(st.nextToken()); // 맨홀 - x 좌표
			C = Integer.parseInt(st.nextToken()); // 맨홀 - y 좌표
			L = Integer.parseInt(st.nextToken()); // 소요된 시간

			answer = 0;
			map = new int[N][M];
			visit = new boolean[N][M];

			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < M; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}

			BFS(R, C);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void BFS(int start_x, int start_y) {

		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(start_x, start_y));
		visit[start_x][start_y] = true;

		int cur_day = 0;

		while (!queue.isEmpty() && cur_day != L) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {

				Point point = queue.poll();
				int struct = map[point.x][point.y];

				for (int index = 0; index < dir[struct].length; index++) {

					int x = point.x + dir[struct][index][0];
					int y = point.y + dir[struct][index][1];

					if (is_In(x, y) && map[x][y] != 0 && !visit[x][y]) {

						if (is_possible(point, new Point(x, y))) {
							visit[x][y] = true;
							queue.add(new Point(x, y));
						}
					}
				}

				answer++;
			}

			cur_day++;
		}

	}

	public static boolean is_possible(Point start, Point end) {

		int struct = map[end.x][end.y];

		for (int index = 0; index < dir[struct].length; index++) {
			
			int x = end.x + dir[struct][index][0];
			int y = end.y + dir[struct][index][1];
			
			if(x == start.x && y == start.y)
				return true;
		}

		return false;
	}

	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
