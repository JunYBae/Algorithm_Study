import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
	int vertex, cost;

	Point(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
}

public class Main {

	static int N, M, K, X;
	static int cost[];
	static ArrayList<ArrayList<Point>> edge_list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		cost = new int[N + 1];
		edge_list = new ArrayList<ArrayList<Point>>();

		for (int i = 0; i <= N; i++)
			edge_list.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			edge_list.get(start).add(new Point(end, 1));
		}

		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[X] = 0;
		find_route(new Point(X, 0));

		
		boolean check = false;
		for (int i = 1; i <= N; i++) {
			if (cost[i] == K) {
				check = true;
				sb.append(i).append("\n");
			}
		}
		
		if (!check)
			sb.append(-1).append("\n");

		System.out.println(sb.toString());
	}

	public static void find_route(Point start) {

		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		queue.add(start);

		while (!queue.isEmpty()) {

			Point point = queue.poll();

			ArrayList<Point> next_node = edge_list.get(point.vertex);
			for (Point next : next_node) {
				if (point.cost + next.cost < cost[next.vertex]) {
					cost[next.vertex] = point.cost + next.cost;
					queue.add(new Point(next.vertex, cost[next.vertex]));
				}
			}

		}
	}
}
