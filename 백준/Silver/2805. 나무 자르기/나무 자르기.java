import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Main {
	
	static int N, M;
	static long arr[];
	static long answer;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = (long)Integer.parseInt(st.nextToken());
		
		binary_search();
		System.out.println(answer);
	}
	
	public static void binary_search() {
		
		long left = 1, right = 2000000000;
		
		while(left <= right) {
			
			long sum = 0; // 나무 남은거 cm 
			long mid = (left + right) / 2;
			
			for (int i = 0; i < N; i++) 
				sum += Math.max(0, arr[i] - mid);
			
			if (sum >= M) {
				if (answer < mid)
					answer = mid;
				left = mid + 1;
			}
			
			else if (sum < M) {
				right = mid - 1;
			}
			
//			System.out.println(sum + " , " + mid);
		}
		
	}
}
