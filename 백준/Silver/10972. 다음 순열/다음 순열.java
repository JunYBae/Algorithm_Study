import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int copy_arr[] = arr.clone();
		
		int index = arr.length - 1;
		while(index > 0 && arr[index-1] > arr[index]) {
			index--;
		}
		
		if(index == 0) {
			System.out.println("-1");
			return;
		}
		
		int index_2 = arr.length - 1;
		while (arr[index-1] > arr[index_2]) {
			index_2--;
		}
		
		int temp = arr[index-1];
		arr[index-1] = arr[index_2];
		arr[index_2] = temp;

		
		int k = arr.length - 1;
		while(index < k) {
			int temp_2 = arr[index];
			arr[index] = arr[k];
			arr[k] = temp_2;
			k--;
			index++;
		}
		

		for (int num : arr) {
			System.out.print(num + " ");
		}
		
	}
}