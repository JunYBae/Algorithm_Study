import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long prev_N1 = 1, prev_N2 = 2;
		int index = 3;
		
		if (N == 1) 
			System.out.println(1); 
		
		else if (N == 2)
			System.out.println(2);
		
		else {
			while(index <= N) {
		
				long temp = (prev_N1 + prev_N2) % 10007;
				prev_N1 = prev_N2;
				prev_N2 = temp;
	
				index++;
			}
			System.out.println(prev_N2 % 10007);
		}
	}
}