import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int check = 1;
		
		for(int i = 1; i <= 6; i++) {
			if(i == 3)
				check = 2;
			else if(i == 6)
				check = 8;
			
			int temp = s.nextInt();
			
			System.out.print(check - temp + " ");
		
		}
	}
}
