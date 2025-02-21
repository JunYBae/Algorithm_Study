import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int S, P, answer;
	static int limit_A, limit_C, limit_G, limit_T;
	static int DNA_list[][]; // DNA 리스트 (누적합)
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken()); // 문자열 길이
		P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
		answer = 0;
		
		DNA_list = new int[S+1][4]; // DNA 정보 (누적합)
		
		String str = br.readLine();
		for (int i = 1; i <= S; i++) {
			char ch = str.charAt(i-1);
			
			switch(ch) {
			case 'A':
				DNA_list[i][0] += DNA_list[i-1][0] + 1;
				DNA_list[i][1] = DNA_list[i-1][1];
				DNA_list[i][2] = DNA_list[i-1][2];
				DNA_list[i][3] = DNA_list[i-1][3];
				break;
				
			case 'C':
				DNA_list[i][0] = DNA_list[i-1][0];
				DNA_list[i][1] += DNA_list[i-1][1] + 1;
				DNA_list[i][2] = DNA_list[i-1][2];
				DNA_list[i][3] = DNA_list[i-1][3];
				break;
				
			case 'G':
				DNA_list[i][0] = DNA_list[i-1][0];
				DNA_list[i][1] = DNA_list[i-1][1];
				DNA_list[i][2] += DNA_list[i-1][2] + 1;
				DNA_list[i][3] = DNA_list[i-1][3];
				break;
				
			case 'T':
				DNA_list[i][0] = DNA_list[i-1][0];
				DNA_list[i][1] = DNA_list[i-1][1];
				DNA_list[i][2] = DNA_list[i-1][2];
				DNA_list[i][3] += DNA_list[i-1][3] + 1;
				break;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		limit_A = Integer.parseInt(st.nextToken());
		limit_C = Integer.parseInt(st.nextToken());
		limit_G = Integer.parseInt(st.nextToken());
		limit_T = Integer.parseInt(st.nextToken());
		
		DP_gogo(); 
		System.out.println(answer); // 답 출력
	}
	
	public static void DP_gogo() {
		
		for (int forward = P; forward <= S; forward++) {
			int backward = forward - P; 
			
			int cur_A = DNA_list[forward][0] - DNA_list[backward][0];
			int cur_C = DNA_list[forward][1] - DNA_list[backward][1];
			int cur_G = DNA_list[forward][2] - DNA_list[backward][2];
			int cur_T = DNA_list[forward][3] - DNA_list[backward][3];
			
			if (cur_A >= limit_A && cur_C >= limit_C && cur_G >= limit_G && cur_T >= limit_T)
				answer++;
		}
	}

}


