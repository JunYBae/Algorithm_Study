import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static int array[][] = new int[19][19];
	static int direction[][] = {{0, 1}, {1, 0}, {1,1}, {-1, 1}};
	static int win_x, win_y;
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("Test5.txt"));
		//---------여기에 코드를 작성하세요.---------------//
		Scanner sc = new Scanner(System.in);
		int who_is_win = 0;
		
		for (int i = 0; i < 19; i++) 
			 for (int j = 0; j < 19; j++)
				 array[i][j] = sc.nextInt();
		
		for (int i = 0; i < 19 && who_is_win == 0; i++) 
		{
			for (int j = 0; j < 19 && who_is_win == 0; j++)
			{
				if (array[i][j] != 0)
				{
					if(is_win(array[i][j], i, j)) {
						win_x = i;
						win_y = j;
						who_is_win = array[i][j];
					}
				}
			}
		}
		
		System.out.println(who_is_win);
		if(who_is_win != 0)
			System.out.println((win_x+1) + " " + (win_y+1));
		
		sc.close();
	}
	
	public static boolean is_win(int color, int x, int y) {
		
		boolean success;
		
		for (int i = 0; i < direction.length; i++)
		{	
			success = true;
			int temp_x = x + direction[i][0] * -1;
			int temp_y = y + direction[i][1] * -1;
			
			if (is_In(temp_x, temp_y) && array[temp_x][temp_y] == color) {
				success = false;
				continue;
			}
			
			temp_x = x + direction[i][0] * 5;
			temp_y = y + direction[i][1] * 5;
			
			if (is_In(temp_x, temp_y) && array[temp_x][temp_y] == color) {
				success = false;
				continue;
			}
						
			for (int index = 0; index < 5; index++)
			{
				temp_x = x + direction[i][0] * index;
				temp_y = y + direction[i][1] * index;				
//				System.out.println(temp_x + ", " + temp_y);
				
				if (is_In(temp_x, temp_y)) {
					if (index != 5 && array[temp_x][temp_y] != color) {
						success = false;
						break;
					}
				}
				else {
					success = false;
					break;
				}
			}
			
			if (success)
				return true;
		}
		return false;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < 19 && y < 19)
			return true;
		return false;
	}

}
