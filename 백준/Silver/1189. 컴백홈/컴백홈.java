import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, K, answer;
	static int map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int x = 0; x < R; x++) {
			String str = br.readLine();
			for (int y = 0; y < C; y++) {
				if(str.charAt(y) == '.') 
					map[x][y] = 0;
				else
					map[x][y] = 1;
			}
		}
		
		map[R-1][0] = 1;
		Tracking(R-1, 0, 1);
		System.out.println(answer);
	}
	
	public static void Tracking(int x, int y, int length) {
		
		if (x == 0 && y == C-1) {
			if (length == K)
				answer++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int cur_x = x + dir[i][0];
			int cur_y = y + dir[i][1];
			
			if (cur_x >= 0 && cur_y >= 0 && cur_x < R && cur_y < C && map[cur_x][cur_y] == 0) {
				map[cur_x][cur_y] += 1;
				Tracking(cur_x, cur_y, length+1);
				map[cur_x][cur_y] -= 1;
			}
		}
	}
}