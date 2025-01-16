import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static int K, N;
	static long lan[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		N = sc.nextInt();
		
		lan = new long[K];
		
		for (int i = 0; i < K; i++)		
			lan[i] = sc.nextLong();
		
		Arrays.sort(lan);
		
		System.out.println(binarySearch(N));
	}

	public static long binarySearch(int answer) {
		
		long start = 1, mid, end = lan[K-1];
		long max = 0;
		
		while(start <= end) {

			mid = (start + end) / 2;
			long count = 0;
			
			for (int i = 0; i < K; i++)
				count += lan[i] / mid;
			
			if (count >= answer) {
				max = mid;
				start = mid + 1;
			}
			
			
			else if (count < answer) {
				end = mid - 1;
			}
		}
		return max;
	}
	
	
}