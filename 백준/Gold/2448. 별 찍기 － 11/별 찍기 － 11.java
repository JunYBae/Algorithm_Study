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
		map = new char[N][N*2-1];
		
		for (int x = 0; x < N; x++)
			Arrays.fill(map[x], ' ');

		simulation(0, N-1, N);
	
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N*2-1; y++)
				sb.append(map[x][y]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void simulation (int x, int y, int length) {
		
		if (length == 3) {
			map[x][y] = '*';
			map[x+1][y-1] = map[x+1][y+1] = '*';
			map[x+1][y] = ' ';
			map[x+2][y-2] = map[x+2][y-1] = map[x+2][y] = map[x+2][y+1] = map[x+2][y+2] = '*'; 
			return;
		}
		
		
		simulation(x, y, length/2);
		simulation(x + length/2, y - length/2, length/2);
		simulation(x + length/2, y + length/2, length/2);
		
	}
}
