import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st;

		
		
		while (!(st = br.readLine()).equals("end")) {
			char prev = 0; // 이전 글자
			boolean exist_aeiou = false; // 자음 있는지 
			int continue_length[] = new int[2]; // 0 : 자음, 1: 모음
			boolean is_success = true;
			
			for (int index = 0; index < st.length(); index++)
			{
				char cur_char = st.charAt(index);
				
				if (prev == cur_char) {
					if (prev == 'e' || prev == 'o') {

					}
					else {
						is_success =false;
						break;
					}
				}
							
				if ("aeiou".contains(cur_char + "")) {
					exist_aeiou = true;
					continue_length[0]++;
					continue_length[1] = 0;
				}
				
				else {
					continue_length[1]++;
					continue_length[0] = 0;
				}
				
				if (continue_length[0] == 3 || continue_length[1] == 3) {
					is_success = false;
					break;
				}
				
				prev =  cur_char;
			}
			
			
			if (is_success && exist_aeiou)
				System.out.println("<" + st + "> " +  "is acceptable.");
			else
				System.out.println("<" + st + "> " +  "is not acceptable.");
		}
		
	}
	
}
