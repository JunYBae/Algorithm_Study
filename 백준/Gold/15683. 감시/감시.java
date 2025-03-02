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
	int type, x, y;

	Point(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M, answer, map[][];
	static ArrayList<Point> cctv_list;
	static int dir[][][][] = {
			{},
			{ {{-1, 0}}, {{1, 0}}, {{0, 1}}, {{0, -1}} },
			{ {{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}} },
			{ {{-1, 0}, {0, 1}}, {{0, -1}, {-1, 0}}, {{1, 0}, {0, -1}}, {{0, 1}, {1, 0}} },
			{ {{0, 1}, {-1, 0}, {0, -1}}, {{-1, 0}, {0, -1}, {1, 0}}, 
			  {{0, -1}, {1, 0}, {0, 1}}, {{1, 0}, {0, 1}, {-1, 0}} },
			{ {{-1, 0}, {0, -1}, {1, 0}, {0, 1}} }
	};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = Integer.MAX_VALUE;
		cctv_list = new ArrayList<Point>();
		
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				if(map[x][y] != 0 && map[x][y] != 6)
					cctv_list.add(new Point(map[x][y], x, y));
			}
		}
		
		simulation(0);
		sb.append(answer).append("\n");
		System.out.println(sb.toString());
	}
	
	public static void simulation(int vertex) {
		
		if (vertex == cctv_list.size()) {
			int temp = calculate(map);
			if(temp < answer)
				answer = temp;
			return;
		}
		
		Point cctv = cctv_list.get(vertex);
		int cctv_type[][][] = dir[cctv.type];
		
		for (int i = 0; i < cctv_type.length; i++) {
			int direction[][] = cctv_type[i];
			
			for (int index = 0; index < direction.length; index++) {
				add_or_remove(cctv, direction[index], true);
			}
			simulation(vertex+1);
			for (int index = 0; index < direction.length; index++) {
				add_or_remove(cctv, direction[index], false);
			}
		}
		
	}
	
	
	public static void add_or_remove (Point cctv, int direction[], boolean is_see) {
		
		int step = 1;
		
		while(true) {
			int x = cctv.x + direction[0] * step;
			int y = cctv.y + direction[1] * step;
			
			if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 6)
				break;
			
			if (map[x][y] == 1) {
				step++;// cctv 면? 넘겨
				continue;
			}
			
			map[x][y] += is_see ? -1 : 1; 
			step++;
		}
	}
	
	public static int calculate(int map[][]) {
		int count = 0;
		
		for (int x = 0; x < N; x++) 
			for (int y = 0; y < M; y++)
				if (map[x][y] == 0)
					count++;
		
		return count;
	}
}

