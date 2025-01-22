import java.util.Scanner;

class Solution {
	
	static int array[][], cost[][], array_max_cost, N;
	static int direction[][] = {{-1,0}, {0,1}, {1,0}, {0, -1}};
	static boolean visit[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			array = new int[N][N];
			cost = new int[N][N];
			visit = new boolean[N][N];
			
			for (int x = 0; x < N; x++)
				for (int y = 0; y < N; y++)
					array[x][y] = sc.nextInt();
			
			
			for (int x = 0; x < N; x++) 
			{
				for (int y = 0; y < N; y++)
				{
					array_max_cost = 0;
					DFS(x, y, 1);
					cost[x][y] = array_max_cost;
				}
			}
			
			
			int max_cost = -1, max_number = -1;
			
			for (int x = 0; x < N; x++) 
			{
				for (int y = 0; y < N; y++)
				{
					if (cost[x][y] > max_cost)
					{
						max_cost =cost[x][y];
						max_number = array[x][y];
					}
					
					else if (cost[x][y] == max_cost)
					{
						if (max_number > array[x][y])
							max_number = array[x][y];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max_number + " " + max_cost);
			
		}
	}
	
	public static void DFS(int x, int y, int depth) {
		
		for (int i = 0; i < direction.length; i++) {
			int temp_x = x + direction[i][0];
			int temp_y = y + direction[i][1];
			
			if (isIn(temp_x, temp_y) && !visit[temp_x][temp_y] && array[x][y] + 1 == array[temp_x][temp_y]) {
				visit[temp_x][temp_y] = true;
				DFS(temp_x, temp_y, depth+1);
				visit[temp_x][temp_y] = false;
			}
		}
		
		if (array_max_cost < depth)
			array_max_cost = depth;
	}
	
	public static boolean isIn(int x, int y) {
		return (x >= 0 && y >= 0 && x < N && y < N);
	}
}









