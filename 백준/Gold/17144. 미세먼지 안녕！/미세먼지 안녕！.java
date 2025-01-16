import java.util.Arrays;
import java.util.Scanner;

// 2025-01-16
// 17144. 미세먼지 안녕!

class Main {
	static Scanner sc = new Scanner(System.in);
	static int array[][];
	static int R, C, T;	// R : 세로, C : 가로, T : 시간
	static int length[] = { -1, 0, 1, 0 };
	static int width[] = { 0, 1, 0, -1 };
	static int location[][]; // 공청기 위 아래 좌표
	static int cost[][];
	
	public static void main(String[] args) {
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		array = new int[R][C];
		location = new int[2][2];
		cost = new int[R][C];
		
		input_Array();
		
		for (int i = 0; i < T; i++) 
		{
			dust_Spread();
			aircon();
			
		}
		print_Sumdust();
		/*
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(location[i][j] + " ");
			}
			System.out.println();
		}
		*/	
	}
	
	public static void input_Array() {
		
		int index = 0;
		
		for (int i = 0; i < R; i++) { 
			for (int j = 0; j < C; j++) {
				array[i][j] = sc.nextInt();
				if (array[i][j] == -1) {
					location[index][0] = i;
					location[index++][1] = j;
				}
			}
		}
		
		
	}
	
	public static void dust_Spread() {
		int temp[][] = new int[R][C];
		
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			{
				if (array[i][j] == -1 || array[i][j] < 5) {
					temp[i][j] += array[i][j];
					continue;
				}				
				
				int count = 0;
				for (int k = 0; k < 4; k++)
				{
					
					int temp_x = i + length[k];
					int temp_y = j + width[k];
					
					if (temp_x >= 0 && temp_y >= 0 && temp_x < R && temp_y < C 
							&& array[temp_x][temp_y] != -1) 
					{
						temp[temp_x][temp_y] += array[i][j] / 5;
						count++;
					}
					
				}
				
				if (count != 0)
					temp[i][j] += array[i][j] - ((array[i][j] / 5) * count);
				else
					temp[i][j] += array[i][j] / 5;	
			}
		}
		
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				cost[i][j] = temp[i][j];
		array = temp.clone();
	}
	
	public static void aircon() {
		
		int up_x = location[0][0];
		int up_y = location[0][1];
		int down_x = location[1][0];
		int down_y = location[1][1];

		
		// 발사
		for (int i = C-1; i > 0; i--) {
			array[up_x][i] = cost[up_x][i-1];
			array[down_x][i] = cost[down_x][i-1];
		}
		
		// 0으로 청정
		array[up_x][1] = 0;
		array[down_x][1] = 0;
		
		
		// 위 또는 아래
		for (int i = 0; i < up_x; i++) {
			array[i][C-1] = cost[i+1][C-1];
		}
		for (int i = R-1; i > down_x; i--) {
			array[i][C-1] = cost[i-1][C-1];
		}
		
		// 공기청청기 방향
		for (int i = 0; i < C-1; i++) {
			array[0][i] = cost[0][i+1];
			array[R-1][i] = cost[R-1][i+1];
		}
		
		// 공기청청기  안으로 (위 또는 아래)
		for (int i = up_x-1; i > 0; i--) {
			array[i][0] = cost[i-1][0];
		}
		for (int i = down_x+1; i < R -1; i++) {
			array[i][0] = cost[i+1][0];
		}
		
	}
	
	static public void print_Sumdust() {
		int sum = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (array[i][j] != -1)
					sum += array[i][j];
			}
		}
		
		System.out.println(sum);
	}
}








