import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Main {
	
	static int N, answer;
	static int visit[][];
	static int dir[][] = {{-1,-1}, {1, 1}, {-1, 1}, {1, -1}};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visit = new int[N][N];
		answer = 0;
		
		backTracking(0, 0);
		System.out.println(answer);
	}
	
	public static void backTracking(int vertex, int count) {
		
		if (count == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(visit[vertex][i] == 0) {
							
				attack_range(vertex, i, 1);				
				backTracking(vertex+1, count+1);
				attack_range(vertex, i, -1);
				
			}
		}
		
		
	}
	
	public static void attack_range(int x, int y, int select) {
		
		for (int i = 0; i < N; i++) {
			visit[x][i] += select;
			visit[i][y] += select;
		}
		
		for (int i = 0; i < dir.length; i++) {
			
			int temp = 1;
			
			while(true) {
				
				int cur_x = x + dir[i][0] * temp;
				int cur_y = y + dir[i][1] * temp;
				
				if (is_In(cur_x, cur_y))
					visit[cur_x][cur_y] += select;
				else
					break;
				
				temp++;
				
			}
			
		}

	}
	
	public static boolean is_In(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}

