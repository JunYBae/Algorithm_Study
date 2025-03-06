import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, numbers[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(numbers);
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			int set_num = numbers[i];
			int left = 0;
			int right = N-1;
			
			while (left < right) {
				
				int cur_num = numbers[left] + numbers[right];
				
				if (set_num == cur_num) {
					if (left != i && right != i) {
						answer++;
						break;
					}
					else if (left == i) {
						left += 1;
						continue;
					}
					else {
						right -= 1;
						continue;
					}
				}
				
				else if (set_num < cur_num) 
					right -= 1;				
				
				else 
					left += 1;
				
			}		
		}
			
		System.out.println(answer);
	}


}
