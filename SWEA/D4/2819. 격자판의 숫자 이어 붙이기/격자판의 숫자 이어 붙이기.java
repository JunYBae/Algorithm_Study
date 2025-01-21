import java.util.HashSet;
import java.util.Scanner;

class Solution {
	static HashSet<String> set;
	static int array[][];
	static int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		//코드를 작성해주세요. 
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			array = new int[4][4];
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					array[i][j] = sc.nextInt();
			
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					DFS(i, j, new String(), 0);
			
			System.out.println("#" + test_case + " " + set.size());
		}
	}
	
	public static void DFS(int x, int y, String st, int depth) {
		
		if (depth == 7) {
			set.add(st);
			return;
		}
		
		for (int i = 0; i < 4; i++)
		{
			int temp_x = x + direction[i][0];
			int temp_y = y + direction[i][1];
			if (isIn(temp_x, temp_y)) 
			{
				String next_st = st + array[temp_x][temp_y];
				DFS(temp_x, temp_y, next_st, depth+1);
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return (x >= 0 && x < 4 && y >= 0 && y < 4);
	}
}


