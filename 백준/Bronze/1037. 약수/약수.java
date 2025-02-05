import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = 0, min = Integer.MAX_VALUE;
		
		for (int test_case = 1; test_case <= T; test_case++) 
		{
			int temp = Integer.parseInt(st.nextToken());
			
			if (max < temp)
				max = temp;
			if (temp < min)
				min = temp;
		}
		
		bw.write((max*min) + "");
		bw.flush();
	}
}
