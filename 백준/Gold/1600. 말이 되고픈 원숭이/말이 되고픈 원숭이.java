import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point{
	int x, y, horse_count; // 저건 말 몇번 썼는지
	
	Point(int x, int y, int horse_count) {
		this.x = x;
		this.y = y;
		this.horse_count = horse_count;
	}
}

public class Main {
	
	static int K, W, H; // W : 가로, H : 세로, K : 말 개수
	static int map[][], cost[][][]; // 맵, 비용 맵
	static int dir[][] = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, // 말
							{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 원숭이
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine()); // 말처럼 이동~ 이히히힝
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W]; // 맵 정보
		cost = new int[H][W][K+1]; // 비용 정보 -> 말 0번 썼을때, 1번썼을때 비용
		
		for (int x = 0; x < H; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < W; y++) {
				Arrays.fill(cost[x][y], 100000);
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		cost[0][0][0] = 0;
		
		System.out.println(find_BFS());
	}
	
	// 원숭이가 길을 찾을 수 있는지 확인
	public static int find_BFS() {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0)); // 처음 위치 넣어주기
		
		while(!queue.isEmpty()) {
			
			int size = queue.size(); // 하루동안 이동하는 애들
			
			for (int i = 0; i < size; i++) {
				
				Point point = queue.poll();
				
				if (point.x == H-1 && point.y == W-1)
					return cost[point.x][point.y][point.horse_count];
				
				// 말로 이동하는거 남았으면?
				if (point.horse_count < K) {
					
					for (int index = 0; index <= 7; index++) {
						
						int x = point.x + dir[index][0];
						int y = point.y + dir[index][1];
						
						if (is_In(x, y) && 	cost[point.x][point.y][point.horse_count] + 1 < cost[x][y][point.horse_count + 1]) {
							cost[x][y][point.horse_count + 1] = cost[point.x][point.y][point.horse_count] + 1;
							queue.add(new Point(x, y, point.horse_count+1));
						}
						
					}
				}
				
				// 원숭이 처럼 이동
				for (int index = 8; index < dir.length; index++) {
					
					int x = point.x + dir[index][0];
					int y = point.y + dir[index][1];
					
					if (is_In(x, y) && cost[point.x][point.y][point.horse_count] + 1 <cost[x][y][point.horse_count]) {
					
						cost[x][y][point.horse_count] = cost[point.x][point.y][point.horse_count] + 1;
						queue.add(new Point(x, y, point.horse_count));
						
					} 
				}	
			}
			
//			for (int x = 0; x < H; x++) {
//				for (int y = 0; y < W; y++)
//					System.out.print(cost[x][y][1] + "\t");
//				System.out.println();
//			}
		}
		
		return -1;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < H && y < W && map[x][y] != 1) 
			return true;
		return false;
	}
}













