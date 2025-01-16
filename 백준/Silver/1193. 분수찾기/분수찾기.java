import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int sum = 1, count = 1;
		boolean is_reverse = true;
		
		int up = 0, down = 0;

		
		while(N > sum) {
			sum += ++count;
			is_reverse = !is_reverse;
		}
		
		if(is_reverse) {
			up = 1 + (sum - N);
			down = count - (sum - N);
		}
		
		else {
			up = count - (sum - N);
			down = 1 + (sum - N);
		}
		
		System.out.println(up +"/"+ down);
	}

}