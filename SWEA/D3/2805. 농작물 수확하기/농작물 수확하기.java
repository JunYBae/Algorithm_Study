import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			result = 0;
			
			for (int i = N/2; Math.abs(i) <= N/2; i--) {	
				String str = br.readLine();
				for (int j = Math.abs(i); j < N-Math.abs(i); j++) {
					result += str.charAt(j) - '0';
				}
			}
			

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
