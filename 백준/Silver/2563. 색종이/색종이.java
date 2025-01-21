import java.util.Scanner;

class Main {
	
	static int array[][] = new int[101][101];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int cur_x = x; cur_x < x+10; cur_x++)
			{
				for (int cur_y = y; cur_y < y+10; cur_y++)
				{
					array[cur_x][cur_y] = 1;
				}
			}
		}
		
		int count = 0;
		
		for (int x = 1; x <= 100; x++)
			for (int y = 1; y <= 100; y++)
				if (array[x][y] == 1)
					count++;
		
		System.out.println(count);
	}
}