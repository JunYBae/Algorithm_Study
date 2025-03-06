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
		
		int first = 0, second = N-1;
		long answer = Long.MAX_VALUE;
		Long[] answer_list = new Long[2];
		
		while(first < second) {
			
			long sum = numbers[first] + numbers[second];
			if (Math.abs(sum) <= Math.abs(answer)) {
				answer = sum;
				answer_list[0] = numbers[first];
				answer_list[1] = numbers[second];
			}
			
			if (sum == 0) {
				sb.append(numbers[first]).append(" ").append(numbers[second]);
				System.out.println(sb.toString());
				return;
			}
			
			else if (sum < 0) 
				first += 1;
			
			else if (sum > 0)
				second -= 1;
		
		}
		
		sb.append(answer_list[0]).append(" ").append(answer_list[1]);
		System.out.println(sb.toString());
		return;
	}
}
