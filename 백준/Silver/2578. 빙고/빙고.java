
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int array[][] = new int[5][5];
	static boolean bingo[][] = new boolean[5][5];
	static int bingo_count = 0;
	
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		for (int x = 0; x < 5; x++)
			for(int y = 0; y < 5; y++)
				array[x][y] = sc.nextInt();
		
		int count = 1;
		
		while(count <= 25) {
			
			int select = sc.nextInt();
			
			for (int x = 0; x < 5; x++) {
				boolean check = false;
				for (int y = 0; y < 5; y++) {
					if (array[x][y] == select) {
						bingo[x][y] = true;
						check = true;
						break;
					}
				}
				
				if (check)
					break;
			}
			
			
			int bingo_count = bingo_check();
			if (bingo_count >= 3) {
				System.out.println(count);
				return;
			}		
			
			count++;
		}
	}
	
	public static int bingo_check() {
		
		int count = 0;
		
		// 가로 체크
		for (int x = 0; x < 5; x++) {
			boolean is_bingo = true;
			for (int y = 0; y < 5; y++) {
				if (bingo[x][y] == false) {
					is_bingo = false;
					break;
				}
			}
			if (is_bingo)
				count++;
		}	
		// 세로 체크
		for (int y = 0; y < 5; y++) {
			boolean is_bingo = true;
			for (int x = 0; x < 5; x++) {
				if (bingo[x][y] == false) {
					is_bingo = false;
					break;
				}
			}
			if (is_bingo)
				count++;
		}
		// 대각선 체크 - 왼 
		boolean is_bingo = true;
		for (int temp = 0; temp < 5; temp++) {
			if (bingo[temp][temp] == false) {
				is_bingo = false;
				break;
			}
		}
		
		if(is_bingo)
			count++;
		
		// 대각선 체크 - 오른
		is_bingo = true;
		for (int temp = 4; temp >= 0; temp--) {
			if (bingo[4-temp][temp] == false ) {
				is_bingo = false;
				break;
			}
		}
		
		if (is_bingo)
			count++;	
		
		return count;
	}
	
}
