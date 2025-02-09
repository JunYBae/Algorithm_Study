import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static PriorityQueue<Integer> queue = new PriorityQueue<>(
			new Comparator<Integer>() {				
				@Override
				public int compare(Integer o1, Integer o2) {
					if (Math.abs(o1) == Math.abs(o2))
						return Integer.compare(o1, o2);
					else
						return Integer.compare(Math.abs(o1), Math.abs(o2));
				}
			}
			); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			int cur = Integer.parseInt(br.readLine());
			
			if (cur == 0) {
				if (queue.isEmpty()) { 
					bw.write("0\n");
				} else {
					bw.write(queue.poll() + "\n");
				} 
				continue;
			} else {
				queue.add(cur);
			}
		}
		
		bw.flush();
		
	}
}