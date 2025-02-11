import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int X= Integer.parseInt(br.readLine());
	
		Arrays.sort(arr);
		
		int start = 0, end = arr.length-1;
		
		int count = two_pointer(start, end, X, arr);
		System.out.println(count);
	}
	
	public static int two_pointer(int start, int end, int X, int arr[]) {
		
		int count = 0;
		
		while(start < end) {
			
			int sum = arr[start] + arr[end];
			
			if (sum == X) {
				count++;
				start++;
				end--;
			} else if (sum < X) {
				start++;
				
			} else {
				end--;			
			}	
		}
		
		return count;
	}
}