import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int length, int width) {
		this.x = length;
		this.y = width; 
	}
}

public class Main {

	static Queue<Point> queue = new ArrayDeque<>();
	static int array[][], M, N; // M : 가로, N : 세로\
	static int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int day;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				array[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (array[i][j] == 1)
					queue.add(new Point(i, j));
				
		BFS();
		
		if (is_success())
			bw.write(day + "\n");
		else
			bw.write("-1\n");
		bw.flush();
	}
	
	public static void BFS() {
		
		day = -1;
				
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) 
			{
				Point point = queue.poll();
				
				for (int index = 0; index < 4; index++)
				{
					int temp_x = point.x + dir[index][0];
					int temp_y = point.y + dir[index][1];
					
					if (isIn(temp_x, temp_y) && array[temp_x][temp_y] == 0
							&& array[temp_x][temp_y] != -1) {
						array[temp_x][temp_y] = 1;
						queue.add(new Point(temp_x, temp_y));
					}
				}
				
			}
			
			day++;
		}
	
	}
	
	public static boolean isIn(int x, int y) {
		
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		else
			return false;
	}
	
	public static boolean is_success() {
			
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				if (array[i][j] == 0) 
					return false;
		
		return true;		
	}
}















