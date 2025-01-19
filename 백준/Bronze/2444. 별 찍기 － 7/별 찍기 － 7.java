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
		
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i = N-1; Math.abs(i) < N; i--) 
		{
			for (int j = 0; j < Math.abs(i); j++)
				bw.write(" ");
			
			for (int j = Math.abs(i); j < N ; j++)
				bw.write("*");
			
			for (int j = Math.abs(i)+1; j < N; j++)
				bw.write("*");
			
			
			bw.newLine();
		}
			
		bw.flush();
	}
}

