import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int row = s.nextInt();
		int col = s.nextInt();
		
		int array[][] = new int[row][col];
		
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < col; j++)
				array[i][j] = s.nextInt();
		
		int checking_t = s.nextInt();
		
		for(int i = 0; i < checking_t; i++) {
			
			int row_s = s.nextInt();
			int col_s = s.nextInt();
			int row_e = s.nextInt();
			int col_e = s.nextInt();
			
			int sum = 0;
			
			for(int k = row_s - 1; k < row_e; k++) {
				for(int j = col_s - 1; j < col_e; j++)
					sum += array[k][j];
			}
			
			System.out.println(sum);
		}
	}
}
