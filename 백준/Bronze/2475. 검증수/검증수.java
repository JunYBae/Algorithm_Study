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
		
		String st[] = br.readLine().split(" ");
		int answer = 0;
		
		for (int i = 0; i < st.length; i++) 
		{
			int temp = Integer.parseInt(st[i]);
			answer += Math.pow(temp, 2);
		}
		
		bw.write(Integer.toString(answer%10));
		bw.flush();
		
	}
}

