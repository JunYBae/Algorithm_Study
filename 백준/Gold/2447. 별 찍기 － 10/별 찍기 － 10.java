import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static char map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int x = 0; x < N; x++)
			Arrays.fill(map[x], ' ');
		
		simulation(0, 0, N);
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				sb.append(map[x][y]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation(int x, int y, int length) {
		
		if (length == 3) {
			for (int i = x; i < x+3; i++) {
				for (int j = y; j < y+3; j++) {
					
					if (i-x == 1 && j-y == 1)
						map[i][j] = ' ';
					else
						map[i][j] = '*';
				}
			}
			return;
		}
		
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if (i == 1 && j == 1) // 빈곳
					continue;			
				simulation(x + ((length/3) * i), y + ((length/3) * j), length/3);
			}
		}
	}
}
