
import java.util.Scanner;

public class Main {
	
	static int array[][];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int length = sc.nextInt();
		int wait_number = sc.nextInt();
		
		int number = width*length;
		int count = 1, direction = 0;
		int cur_x = length-1, cur_y = 0;
		
		array = new int[length][width];
		
		// 0 : 북, 1: 동, 2: 남, 3: 서
		while (count <= number) {
			
			if (direction == 0) {
				if (cur_x == 0 || array[cur_x-1][cur_y] != 0) {
					array[cur_x][cur_y++] = count++;
					direction = (direction + 1) % 4;
				}
				else
					array[cur_x--][cur_y] = count++;
			}
			
			else if (direction == 1) {
				if (cur_y == width-1 || array[cur_x][cur_y+1] != 0) {
					array[cur_x++][cur_y] = count++;
					direction = (direction + 1) % 4;
				}
				else
					array[cur_x][cur_y++] = count++;
			}
			
			else if (direction == 2) {
				if (cur_x == length-1 || array[cur_x+1][cur_y] != 0) {
					array[cur_x][cur_y--] = count++;
					direction = (direction + 1) % 4;
				}
				else
					array[cur_x++][cur_y] = count++;
					
			} 
			
			else if (direction == 3) {
				if (cur_y == 0 || array[cur_x][cur_y-1] != 0) {
					array[cur_x--][cur_y] = count++;
					direction = (direction + 1)  % 4;
				}
				else
					array[cur_x][cur_y--] = count++;
			}
			
		}
		
		int sel_x = 0, sel_y = 0;
		
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < width; y++) {
				if (array[x][y] == wait_number) {
					sel_x = y + 1;
					sel_y = length - x;
					System.out.println(sel_x + " " + sel_y);
					return;
				}
			}
		}
		
		System.out.println(0);
	}
}
