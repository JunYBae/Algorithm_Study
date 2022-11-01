import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int money = s.nextInt();
		int count = s.nextInt();
		int set = 0;
		
		for(int i = 1; i <= count; i++) {
			set += s.nextInt() * s.nextInt();
		}
		
		if(money == set)
			System.out.println("Yes");
			
		else
			System.out.println("No");
		
		s.close();
	}
}
