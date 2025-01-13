import java.util.Scanner;

class Main {
	
	static int R, C;
	
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);
 		
 		R = sc.nextInt();
 		C = sc.nextInt();
 		
 		for (int i = 0; i < R; i++) {
 			for (int j = 0; j < C; j++)
 				System.out.print("*");
 			System.out.println();
 		}
 	}
}