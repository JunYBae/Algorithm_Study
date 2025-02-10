import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			sum += array[i];
		}
		
		if (sum % 3 != 0) { 
			System.out.println("NO");
			return;
		}
		
		int even = sum / 3;
		int temp = 0;
		
		for (int i = 0; i < array.length; i++) {
			temp += array[i]/2;
		}
		
		if (temp >= even)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}