import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static ArrayList<Point> home_list;
	static ArrayList<Point> chicken_list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N*N
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집 개수
		home_list = new ArrayList<Point>(); // 홈 리스트
		chicken_list = new ArrayList<Point>(); // 치킨집 리스트
		answer = Integer.MAX_VALUE; // 정답 
		
		map = new int[N][N];
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < N; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				if(map[x][y] == 1)
					home_list.add(new Point(x, y));
				else if(map[x][y] == 2) 
					chicken_list.add(new Point(x, y));
				
			}
		}

		simulation(0, 0, new ArrayList<Point>());
		sb.append(answer).append("\n");
		System.out.println(sb.toString());
	}
	
	public static void simulation(int vertex, int length, ArrayList<Point> select) {
		
		if (length == M) {
			int total = calculate(select);
			if(answer > total)
				answer = total;
			return;
		}
		
		for (int i = vertex; i < chicken_list.size(); i++) {
			select.add(chicken_list.get(i));
			simulation(i+1, length+1, select);
			select.remove(select.size() - 1);
		}
	}
	
	public static int calculate(ArrayList<Point> select) {
		
		int sum_length = 0;
		
		for (Point home : home_list) {
			int min_length = Integer.MAX_VALUE;
			for (Point chicken : select) {
				int length = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
				if (min_length > length)
					min_length = length;
			}
			sum_length += min_length;
		}
		
		return sum_length;
	}
}

