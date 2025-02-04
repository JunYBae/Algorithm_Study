import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			
			String st = br.readLine();
			
			if (st.equals("ENTER")) {
				count += set.size();
				set.clear();
			} else {
				set.add(st);
			}
		}
		
		count += set.size();
		
		System.out.println(count);
	}
}