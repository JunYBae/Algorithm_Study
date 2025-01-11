import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static int N;
	static int map[][];
	static int sero[] = {0, -1, 0, 1};
	static int garo[] = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new ArrayDeque<>();
	static ArrayList<Integer> array = new ArrayList<>();
	
	public static void BFS() {
		
		int number = 0; // 개수
		
		while(!queue.isEmpty()) 
		{
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) 
			{
				int temp_x = point.x + sero[i];
				int temp_y = point.y + garo[i];
				
				if (temp_x >= 0 && temp_y >= 0 && temp_x < N && temp_y < N
						&& map[temp_x][temp_y] == 1) {
					map[temp_x][temp_y] = 0;
					queue.add(new Point(temp_x, temp_y));
					number++;
				}
			}
		}
		
		if (number == 0)
			number++;
		array.add(number);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) 
				map[i][j] = line.charAt(j) - '0';
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
					BFS();
				}
			}
		}
		
		Collections.sort(array);
		System.out.println(array.size());
		
		for (int i = 0; i <array.size(); i++)
		{
			System.out.println(array.get(i));
		}
				
	}
}