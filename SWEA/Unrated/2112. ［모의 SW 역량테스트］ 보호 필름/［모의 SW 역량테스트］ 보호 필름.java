import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int D, W, K, array[][], min_film;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken()); // 두꼐 (세로)
			W = Integer.parseInt(st.nextToken()); // 평면 (가로)
			K = Integer.parseInt(st.nextToken()); // 합격 기준 (K)
			array = new int[D][W];
			min_film = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) { 
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++)
					array[i][j] = Integer.parseInt(st.nextToken());
			}
			
			
			testing_film(-1, 0);
			
			System.out.println("#" + test_case + " " + min_film);

		}
	}
	
	
	public static void testing_film(int vertex, int depth) {

		boolean complete = true;
		
		for (int y = 0; y < W; y++) {
					
			int prev_num = array[0][y];
			boolean success = false;
			int x = 1;
			int count = 1;
					
			while(x != D) {
				if (array[x][y] == prev_num) {
					count++;
				} else if (array[x][y] != prev_num) {
					prev_num = array[x][y];
					count = 1;
				}if (count == K) {
					success = true;
					break;
				}	
				x++;
			}
					
			if (!success) {
				complete = false;
				break;
			}
		}
		

		if(complete) {
			if (min_film > depth)
				min_film = depth;
			return;
		} else if (depth > min_film) {
			return;
		}
		
		for (int index = vertex+1; index < D; index++) {
			
			int change_array[] = array[index].clone(); // 기존 배열 복사 
			
			for (int y = 0; y < W; y++) 
				array[index][y] = 1;
			testing_film(index, depth+1);
			array[index] = change_array.clone();
			
			
			for (int y = 0; y < W; y++) 
				array[index][y] = 0;
			testing_film(index, depth+1);
			array[index] = change_array.clone();
				
		}
	}
	
	public static void change_film(int x, int change_num) {
		
		for (int y = 0; y < W; y++) {
			array[x][y] = change_num;
		}
		
	}
	
}
