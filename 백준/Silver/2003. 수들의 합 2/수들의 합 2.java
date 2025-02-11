import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int array[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());
		
		int count = two_pointer(array, M);
		System.out.println(count);
	}
	
	public static int two_pointer(int array[], int M) {
		
		int count = 0;
		int start = 0, end = 0;
		double sum = 0;
		
		while (true) {
			
			if (sum < M) {
				sum += array[end++];
			} else if (sum == M) {
				sum+= array[end++];
			} else if (sum > M) {	
				sum -= array[start++];
			}
						
			if (sum == M)
				count++;			
			
			//System.out.println(sum + " " + count);

			if (end == array.length && sum <= M)
				break;
		}
	
		return count;		
	}
}