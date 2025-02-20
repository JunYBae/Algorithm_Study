import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Square {
	int start_x, start_y, end_x, end_y;
	
	Square(int start_x, int start_y, int end_x, int end_y) {
		this.start_x = start_x;
		this.start_y = start_y;
		this.end_x = end_x;
		this.end_y = end_y;
	}
}



public class Main {
	
	static int N, M, map[][];
	static int dir[][] = {{-1, 0}, {0, -1}, {-1, -1}};
	static ArrayList<Square> square_list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 크기 
		M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수 
		map = new int[N][N]; // 맵 정보		
		
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < N; y++) {
				
				int cur_num = Integer.parseInt(st.nextToken());
				
				for (int i = 0; i < 3; i++) {
					int cur_x = x + dir[i][0];
					int cur_y = y + dir[i][1];
					
					if (is_In(cur_x, cur_y)) {	
						if(i <= 1)
							cur_num += map[cur_x][cur_y];
						else
							cur_num -= map[cur_x][cur_y];
					}
				}
				
				map[x][y] = cur_num;
			}
		}		
		
		for (int i = 0; i < M; i++) {
			st =  new StringTokenizer(br.readLine(), " ");
			int start_x = Integer.parseInt(st.nextToken()) - 1;  // 시작 x
			int start_y = Integer.parseInt(st.nextToken()) - 1; // 시작 y
			int end_x = Integer.parseInt(st.nextToken()) - 1; // 끝 x
			int end_y = Integer.parseInt(st.nextToken()) - 1; // 끝 y
					
			square_list.add(new Square(start_x, start_y, end_x, end_y));
		}
		
		for (Square square : square_list) {
			
			int answer = map[square.end_x][square.end_y];
			
			if (is_In(square.start_x - 1, square.start_y - 1))
				answer += map[square.start_x - 1][square.start_y - 1];
			
			if (square.start_x != 0) 
				answer -= map[square.start_x - 1][square.end_y];
			if (square.start_y != 0)
				answer -= map[square.end_x][square.start_y - 1];
			
			sb.append(answer).append("\n");
		}
		
	
		System.out.println(sb.toString());
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}

}



