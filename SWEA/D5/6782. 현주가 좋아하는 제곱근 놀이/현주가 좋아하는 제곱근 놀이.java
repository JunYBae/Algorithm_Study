import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			double N = Double.parseDouble(br.readLine());
			int answer = 0; 
				
			while (N > 2) {
				double temp = Math.ceil(Math.sqrt(N));
				answer += (temp * temp) - N + 1;
				N = temp;
//				System.out.println(answer + " : " + temp);				
			}
						
			if (N < 2) 
				answer += 2 - N; 
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
