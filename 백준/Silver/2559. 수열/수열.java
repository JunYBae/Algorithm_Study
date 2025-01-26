
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// 입력		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int array[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());
		
		// 입력 다 끝남
		
		long max_num = Long.MIN_VALUE;
		
		for (int index = 0; index <= N-K; index++) {
			
			long number = 0;
			for (int cur_index = 0; cur_index < K; cur_index++) {
				number += array[index+cur_index];
			}
			
			if (number > max_num)
				max_num = number;
	
		}
		
		bw.write(String.format("%d", max_num));
		bw.flush();
	}
}

 