import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static long array[];
	static long answer[];
	static int N, M;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		array = new long[N];
		
		for (int i = 0; i < N; i++)
			array[i] = sc.nextLong();
		
		M = sc.nextInt();
		answer = new long[M];
		
		for (int i = 0; i < M; i++)
			answer[i] = sc.nextLong();
		
		Arrays.sort(array);
		
		for (int i = 0; i < M; i++) 
			System.out.println(binarySearch(answer[i]));
		
	}
	
	public static int binarySearch(long answer) {
		
		long start = 0, mid, end = N-1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if (array[(int)mid] == answer)
				return 1;
			
			else if (array[(int)mid] < answer) 
				start = mid + 1;
			
			else if (array[(int)mid] > answer)
				end = mid - 1;
			
		}
		
		return 0;
	}

}
