import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a_size = Integer.parseInt(st.nextToken());
			int b_size = Integer.parseInt(st.nextToken());
			int a_array[] = new int[a_size];
			int b_array[] = new int[b_size];
			int answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a_size; i++) 
				a_array[i] = Integer.parseInt(st.nextToken());
					
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < b_size; i++) 
				b_array[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(a_array);
			Arrays.sort(b_array);
			
			for (int i = 0; i < a_size; i++) {
				for (int j = 0; j < b_size; j++) {
					if (a_array[i] <= b_array[j]) 
						break;
					answer++;
				}
			}
			
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}