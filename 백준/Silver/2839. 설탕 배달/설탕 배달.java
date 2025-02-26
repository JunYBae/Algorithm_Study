import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int five_count = N/5;
		int remain = N % 5;
		
		while (five_count >= 0) {
			
			remain = N - 5 * five_count;
			
			if (remain % 3 == 0) {
				System.out.println(five_count + remain/3);
				return;
			}
				
			five_count--;
		}
		
		System.out.println("-1");
	}

}
