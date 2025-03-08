import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static ArrayList<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(br.readLine());
		
		list.add((long)0);
		list.add((long)1);
		list.add((long)2);
		list.add((long)4);
	
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			if (N <= list.size()-1) {
				System.out.println(list.get(N));
				continue;
			}
			
			long prev_1 = list.get(list.size() - 1);
			long prev_2 = list.get(list.size() - 2);
			long prev_3 = list.get(list.size() - 3);
			int index = list.size() - 1;
			
			while(index <= N) {
				
				long temp = (prev_1 + prev_2 + prev_3) % 1000000009;
				list.add(temp);
				
				prev_3 = prev_2;
				prev_2 = prev_1;
				prev_1 = temp;
	
				index++;
			}
			
			System.out.println(list.get(N));
		}
		
	}
}