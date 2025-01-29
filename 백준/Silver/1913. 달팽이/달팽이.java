import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int set_num = sc.nextInt();
		int cur_N = N * N;
		int array[][] = new int[N][N];
		int dir = 0;
		int x = 0, y = 0;
		int set_x = 0, set_y = 0;
		// 0 : 아래, 1: 오른쪽, 2 : 위, 3 :왼쪽
		
		while(cur_N >= 1) {
			
			array[x][y] = cur_N;
			
			if (set_num == cur_N) {
				set_x = x;
				set_y = y;
			}
			
			switch (dir) {
			case 0:
				if (x == N - 1 || array[x+1][y] != 0) {
					y++;
					dir = (dir + 1) % 4;
				}
				else
					x++;
				break;
				
			case 1:
				if (y == N - 1 || array[x][y+1] != 0) {
					x--;
					dir = (dir + 1) % 4;
				}
				else
					y++;
				break;
				
			case 2:
				if (x == 0 || array[x-1][y] != 0) {
					y--;
					dir = (dir + 1) % 4;
				} 
				else
					x--;
				break;
				
			case 3:
				if (y == 0 || array[x][y-1] != 0) {
					x++;
					dir = (dir + 1) % 4;
				}
				else
					y--;
				break;
				
			}
			
			cur_N--;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
		
		System.out.println((set_x + 1) + " " + (set_y + 1));
	}
}