import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int prev = Integer.parseInt(st.nextToken());
		
		if ((prev != 1 && prev != 8)) {
			System.out.println("mixed");
			return;
		}
		
		if (prev == 1) {
			
			for (int i = 2; i <= 8; i++) {
				if (Integer.parseInt(st.nextToken()) != i) {
					System.out.println("mixed");
					return;
				}
			}
		
			System.out.println("ascending");
			return;
			
		} else if (prev == 8) {
			
			for (int i = 7; i >= 1; i--) {
				if (Integer.parseInt(st.nextToken()) != i) {
					System.out.println("mixed");
					return;
				}
			}
		
			System.out.println("descending");
			return;
		}
 		
				
	}
}