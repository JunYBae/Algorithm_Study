import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int one = s.nextInt();
		int two = s.nextInt();
		int three = s.nextInt();
		
		int count = 0, money = 0, check_c = 0;

		if (one == two) {
			count++;
			check_c = one;
		}

	
		if (two == three){
			count++;
			check_c = two;
		}
			
		if (three == one){
			count++;
			check_c = three;
		}
		
		if(count == 3)
			money = 10000 + check_c * 1000;
		else if(count == 1)
			money = 1000 + check_c * 100;
		else {
			int temp = 0;
			if(temp < one)
				temp = one;
			if(temp < two)
				temp = two;
			if(temp < three)
				temp = three;
			money = temp * 100;
		}
		
		System.out.println(money);
		
		s.close();
	}
}
