import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Point {
	
	int m, n, h;
	
	Point(int m, int n, int h) {
		this.m = m;
		this.n = n;
		this.h = h;
	}
}

class Main {
	
	static int M, N, H;
	static int day;
	static int map[][][];
	static int height[] = { 1, -1, 0, 0, 0, 0 };
	static int length[] = { 0, 0, 0, -1, 0, 1 };
	static int width[] = { 0, 0, -1, 0, 1, 0 };

	static Queue<Point> queue = new ArrayDeque<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][N][M];
		day = 0;
		
		for (int h = 0; h < H; h++)
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++) {
					map[h][n][m] = sc.nextInt();
					if (map[h][n][m] == 1)
						queue.add(new Point(m, n, h));
				}
		
		BFS();
		
		if (!is_success())
			day = -1;
		
		System.out.println(day);
	}
	
	public static void BFS() {
		
		while(!queue.isEmpty()) 
		{
			int size = queue.size();
			boolean is_change = false;
			
			for (int i = 0; i < size; i++)
			{
				Point point = queue.poll();
				
				for (int j = 0; j < 6; j++)
				{
					
					int temp_h = point.h + height[j];
					int temp_n = point.n + length[j];
					int temp_m = point.m + width[j];
					
					if (temp_h >= 0 && temp_n >= 0 && temp_m >= 0 &&
							temp_h < H && temp_n < N && temp_m < M && 
							map[temp_h][temp_n][temp_m] == 0) {
						map[temp_h][temp_n][temp_m] = 1;
						queue.add(new Point(temp_m, temp_n, temp_h));
						is_change = true;
					}
				}				
			}
			
			if (is_change)
				day++;
		}
	}
	
	public static boolean is_success() {
		
		for (int h = 0; h < H; h++)
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					if (map[h][n][m] == 0)
						return false;
		
		return true;
	}
}