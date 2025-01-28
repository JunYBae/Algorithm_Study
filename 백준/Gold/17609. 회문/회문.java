import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			String st = br.readLine();
			
			boolean front_success = true;
			boolean last_success = true;
			boolean is_change = false;
			
			for (int front = 0, end = st.length()-1; front <= end; front++, end--)
			{
		
				if (st.charAt(front) == st.charAt(end))
					continue;
				
				else {
					front_success = is_paildrome(st.substring(front+1, end+1));
					last_success = is_paildrome(st.substring(front, end));
//					System.out.println(st.substring(front+1, end+1));
//					System.out.println(st.substring(front, end));
					is_change = true;
					break;
				}
				
			}
			
			if (front_success && last_success && !is_change)
				bw.write("0\n");
			
			else if (front_success || last_success && is_change)
				bw.write("1\n");
			
			else
				bw.write("2\n");

		}
		
		bw.flush();
	}
	
	public static boolean is_paildrome(String st) {
		
		for (int first = 0, end = st.length() -1; first <= end; first++, end--)
		{
			if (st.charAt(first) != st.charAt(end))
				return false;
		}
		
		return true;
	}
}
