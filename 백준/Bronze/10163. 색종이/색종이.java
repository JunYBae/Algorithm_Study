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
		
		int array[][] = new int[1001][1001];
		int count[] = new int[101];
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start_y = Integer.parseInt(st.nextToken());
			int start_x = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			for (int x = 0; x < length; x++) 
			{
				for (int y = 0; y < width; y++)
				{
					array[1000-start_x-x][1000-start_y-y] = test_case;
				}
			}
		}
		
		
		for (int x = 0; x <= 1000; x++)
		{
			for (int y = 0; y <= 1000; y++)
			{
				if (array[x][y] != 0)
					count[array[x][y]]++;
			}
		}
		
		for (int i = 1; i <= T; i++)
			bw.write(count[i] + "\n");
		
		bw.flush();
	}
}