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

public class Main {
	
	static int N, M, answer;
	static char map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new char[N][M];
		for (int x = 0; x < N; x++) {
			String str = br.readLine();
			for (int y = 0; y < M; y++) 
				map[x][y] = str.charAt(y);
		}
		
		ArrayList<Character> visit = new ArrayList<Character>();
		visit.add(map[0][0]);
		
		DFS(new Point(0, 0), 1, visit);
		System.out.println(answer);
	}
	
	public static void DFS(Point point, int length, ArrayList<Character> visit) {
		
		if (answer < length)
			answer = length;
		
		for (int i = 0; i < dir.length; i++) {
			int x = point.x + dir[i][0];
			int y = point.y + dir[i][1];
			
			if (is_In(x, y) && !visit.contains(map[x][y])) {
				visit.add(map[x][y]);
				DFS(new Point(x, y), length+1, visit);
				visit.remove(visit.size() - 1);
			}
		}
	}
	

	
	public static boolean is_In(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}

