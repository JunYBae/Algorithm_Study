import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int row = s.nextInt();
		int col = s.nextInt();
		int arrayA[][] = new int[row][col];
		int arrayB[][] = new int[row][col];
		int arrayR[][] = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++)
				arrayA[i][j] = s.nextInt();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++)
				arrayB[i][j] = s.nextInt();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++)
				arrayR[i][j] = arrayA[i][j] + arrayB[i][j]; 
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++)
				System.out.print(arrayR[i][j] + " ");
			System.out.println();
		}
		
		s.close();
	}
}
