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
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M, answer, map[][];
	static ArrayList<Point> virus;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<Point>();

		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				if (map[x][y] == 2) {
					virus.add(new Point(x, y));
				}
			}
		}

		make_and_simulation(0, 0, map);
		sb.append(answer).append("\n");
		System.out.println(sb.toString());
	}

	public static void make_and_simulation(int vertex, int prev_x, int map[][]) {

		if (vertex == 3) {
			int temp[][] = new int[N][M];
			for (int x = 0; x < N; x++)
				temp[x] = map[x].clone();

			int safe_zone = simulation(temp);
			if (answer < safe_zone) {
				answer = safe_zone;
			}
			return;
		}

		for (int x = prev_x; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] == 0) {
					map[x][y] = 1;
					make_and_simulation(vertex + 1, x, map);
					map[x][y] = 0;
				}
			}
		}
	}

	public static int simulation(int map[][]) {

		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		queue.addAll(virus);

		while (!queue.isEmpty()) {

			Point point = queue.poll();

			for (int index = 0; index < 4; index++) {
				int x = point.x + dir[index][0];
				int y = point.y + dir[index][1];

				if (is_In(x, y) && map[x][y] == 0) {
					map[x][y] = 2;
					queue.add(new Point(x, y));
				}

			}
		}

		return calculate_safe_zone(map);
	}

	public static int calculate_safe_zone(int map[][]) {

//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < M; y++)
//				System.out.print(map[x][y] + " ");
//			System.out.println();
//		}
//		System.out.println(); 

		int count = 0;

		for (int x = 0; x < N; x++)
			for (int y = 0; y < M; y++)
				if (map[x][y] == 0)
					count++;
		return count;
	}

	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
