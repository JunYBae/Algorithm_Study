import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;


class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int array[][];
	static boolean visit[][];
	static int start_x, start_y, end_x, end_y; 
	static boolean success;
	static int length[] = { -1, 0, 1, 0 };
	static int width[] = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		
		for (int test_case = 1; test_case <= 10; test_case++) 
		{
			int T = Integer.parseInt(br.readLine());
			array = new int[16][16];
			visit = new boolean[16][16];
			success = false;
			
			for (int i = 0; i < 16; i++) {
				String st = br.readLine();
				for (int j = 0; j < 16; j++) {
					array[i][j] = st.charAt(j) - '0';
					if(array[i][j] == 2) {
						start_x = i;
						start_y = j;
					}
					else if (array[i][j] == 3) {
						end_x = i;
						end_y = j;
					}
				}
			}
			
			DFS(start_x, start_y);		
			bw.write("#" + test_case + " " + (success ? 1 : 0));
			bw.newLine();
			bw.flush();
		}
	}
	
	public static void DFS(int x, int y) {
		
		if (x == end_x && y == end_y) {
			success = true;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int temp_x = x + length[i];
			int temp_y = y + width[i];
			
			if (temp_x >= 0 && temp_y >= 0 && temp_x < 16 && temp_y < 16 
					&& !visit[temp_x][temp_y])
				if(array[temp_x][temp_y] != 1) {
					visit[temp_x][temp_y] = true;
					DFS(temp_x, temp_y);
				}
		}
	}
}
