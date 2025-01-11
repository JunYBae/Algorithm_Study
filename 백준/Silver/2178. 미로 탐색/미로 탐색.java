import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	
	static int N, M;
	static int map[][];
	static Queue<Point> queue = new ArrayDeque<>();
	
	static int sero[] = {0, -1, 0, 1};
	static int garo[] = {-1, 0, 1, 0};
	
	public static void BFS() {
		
		while (!queue.isEmpty())
		{
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) 
			{
				int temp_x = point.x + sero[i];
				int temp_y = point.y + garo[i];
				
				if (temp_x >= 0 && temp_y >= 0 && temp_x < N && temp_y < M 
						&& map[temp_x][temp_y] == 1)
				{
					map[temp_x][temp_y] = map[point.x][point.y] + 1;
					queue.add(new Point(temp_x, temp_y));
				}
			}
		}
				
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++)
		{
			String line = sc.next();
			for (int j = 0; j < M; j++)
			{
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		queue.add(new Point(0, 0));
		BFS();
		
		System.out.println(map[N-1][M-1]);
	}
}