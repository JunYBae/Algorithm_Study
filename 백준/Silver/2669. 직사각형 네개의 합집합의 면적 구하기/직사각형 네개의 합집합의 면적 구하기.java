
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		boolean array[][] = new boolean[101][101];
		
		for (int count = 1; count <= 4; count++)
		{
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int end_x = sc.nextInt();
			int end_y = sc.nextInt();
			
			for (int x = start_x; x < end_x; x++)
				for (int y = start_y; y < end_y; y++)
					array[x][y] = true;
		}
		
		int extent = 0;
		
		for (int x = 1; x <= 100; x++)
			for (int y = 1; y <= 100; y++)
				if(array[x][y] == true)
					extent++;
		
		System.out.println(extent);
		
	}
}

 