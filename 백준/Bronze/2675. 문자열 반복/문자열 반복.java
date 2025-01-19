import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++)
		{
			String st[] = br.readLine().split(" ");
			
			for (int i = 0; i < st[1].length(); i++) 
				for (int j = 0; j <  Integer.parseInt(st[0]); j++)
					bw.write(st[1].charAt(i));
				
			bw.newLine();
		}
		
		bw.flush();
	}
}

