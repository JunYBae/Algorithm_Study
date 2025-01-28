import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++)
		{
			int temp = Integer.parseInt(br.readLine());
			
			if (temp == 0) 
				bw.write((queue.peek() == null ? 0 : queue.poll()) + "\n");
			else
				queue.add(temp);
		}
		
		bw.flush();
	}
	
}















