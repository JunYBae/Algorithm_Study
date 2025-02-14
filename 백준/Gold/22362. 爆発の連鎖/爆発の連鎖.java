import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	
	static int W, H, N, D, B, count;
	static int map[][];
	static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Point first;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken()); // 가로
			H = Integer.parseInt(st.nextToken()); // 세로
			N = Integer.parseInt(st.nextToken()); // 폭탄 수
			D = Integer.parseInt(st.nextToken()); // 폭탄 폭발 크기
			B = Integer.parseInt(st.nextToken()); // 처음 폭발하는 폭탄
			
			if(W == 0 && H == 0 && N == 0 && D == 0 && B == 0)
				break;
			
			map = new int[H+1][W+1];
			count = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(st.nextToken()); 
				int x = Integer.parseInt(st.nextToken()); 
				map[x][y] = 1;
				
				if (i == B)
					first = new Point(x, y);
	
			}
			
			simulation();
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation() {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(first);
		map[first.x][first.y] = 0;
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
	
			for (int i = 0; i < 4; i++) {
				
				for (int index = 1; index <= D; index++) {
					
					int x = point.x + dir[i][0] * index;
					int y = point.y + dir[i][1] * index;
					
					if(is_In(x, y) && map[x][y] == 1) {
						queue.add(new Point(x, y));
						map[x][y] = 0;
					}
				}
			}
			
			count++;
		}
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 1 && y >= 1 && x <= H && y <= W)
			return true;
		return false;
	}
	
}

