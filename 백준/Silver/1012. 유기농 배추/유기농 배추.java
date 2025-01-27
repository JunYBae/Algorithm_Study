
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	
	static int array[][], worm;
	static boolean visit[][];
	static int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int vagetable_count = Integer.parseInt(st.nextToken());
			
			array = new int[length][width];
			visit = new boolean[length][width];
			worm = 0;
			
			for (int i = 0; i < vagetable_count; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				array[x][y] = 1;
			}
			
			
			for (int x = 0; x < length; x++) 
			{
				for (int y = 0; y < width; y++)
				{
					if (array[x][y] == 1 && !visit[x][y])
					{
						BFS(x, y, length, width);
					}
				}
			}
			
			bw.write(worm+"\n");
		}
		
		bw.flush();
	}
	
	public static void BFS(int x, int y, int length, int width) {
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		// 첫 스타트
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) 
			{
				Point point = queue.poll();
				
				for (int index = 0; index < 4; index++)
				{
					int temp_x = point.x + direction[index][0];
					int temp_y = point.y + direction[index][1];
					
					if(isIn(temp_x, temp_y, length, width) && !visit[temp_x][temp_y] &&
							array[temp_x][temp_y] == 1)
					{	
					
						queue.add(new Point(temp_x, temp_y));
						visit[temp_x][temp_y] = true;
					}
							
				}
			
			}			
			
		}
		
		worm++;
	}
	
	public static boolean isIn(int x, int y, int length, int width) {
		
		if (x >= 0 && y >= 0 && x < length && y < width)
			return true;
		else 
			return false;
	}
}

 

