import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int a_array[] = new int[10000];
			int b_array[] = new int[10000];
			boolean change = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens())
				a_array[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens())
				b_array[Integer.parseInt(st.nextToken())]++;
		
			
			for (int index = 4; index >= 1; index--)
			{
				if (a_array[index] > b_array[index]) {
					bw.write("A\n");
					change = true;
					break;
				} else if (a_array[index] < b_array[index]) {
					bw.write("B\n");
					change = true;
					break;
				} 
			}
			
			if (!change)
				bw.write("D\n");
		}
		
		bw.flush();
	}
}