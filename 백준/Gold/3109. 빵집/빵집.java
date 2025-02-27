import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, result;
	static StringBuilder sb[];
	static int dir[][] = {{-1, 1}, {0, 1}, {1, 1}};
	static boolean success;


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		sb = new StringBuilder[R]; // 배열 
		
		
		for (int i = 0; i < R; i++) {
			sb[i] = new StringBuilder();
			sb[i].append(br.readLine());
		}
		
		for (int index = 0; index < R; index++) {
			success = false;
			pipe_line(index, 0);
		}
		
		System.out.println(result);
	}
	
	static public void pipe_line(int x, int y) {
		
		if (y == C-1) {
			result++;
			success = true;
			return; 
		}
		
		for (int index = 0; index < dir.length && !success; index++) {
			
			int next_x = x + dir[index][0];
			int next_y = y + dir[index][1];
			
			
			if (is_In(next_x, next_y) && sb[next_x].charAt(next_y) != 'x') {
				
				sb[next_x].setCharAt(next_y, 'x');	
				pipe_line(next_x, next_y);
				
				if (success)
					return;
				
			}
		}
	}
	
	static public boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}
}

