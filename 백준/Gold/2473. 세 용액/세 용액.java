import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long numbers[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		numbers = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Long.parseLong(st.nextToken());

		Arrays.sort(numbers);
		
		long correct = Long.MAX_VALUE;
		long answer[] = new long[3];
		
		for (int i = 0; i < N-2; i++) {
			int second = i + 1;
			int third = N - 1;
			
			while (second < third) {
				long sum = numbers[i] + numbers[second] + numbers[third];
				
				if (Math.abs(sum) < Math.abs(correct)) {
					correct = sum;
					answer[0] = numbers[i];
					answer[1] = numbers[second];
					answer[2] = numbers[third];
				}
				
				if (sum == 0) {
					sb.append(numbers[i]).append(" ").append(numbers[second]).append(" ").append(numbers[third]);
					System.out.println(sb.toString());
					return;
				}
				
				if (sum < 0)
					second += 1;
				else if (sum > 0)
					third -= 1;
					
			}
		}
		
		for (long num : answer)
			sb.append(num).append(" ");
		System.out.println(sb.toString());
	}
}
