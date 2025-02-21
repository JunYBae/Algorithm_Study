import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.util.Elements;

public class Main {
	
	static int N, M, answer;
	static ArrayList<Integer> required;
	static int number[], required_use[];
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 비밀번호 길이
		M = Integer.parseInt(st.nextToken()); // 비밀번호에 들어가는 수 개수
		
		required = new ArrayList<>();
		number = new int[N];
		required_use = new int[10];
		answer = 0;
		
		if (M != 0) {
			st =  new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				required.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		simulation(0);
		System.out.println(answer);
		
	}
	
	public static void simulation(int length) {
		
		if (length == N) {
			for (int num : required)
				if(required_use[num] == 0)
					return;
			answer++;
			return; 
		}
		
		for (int i = 0; i <= 9; i++) {
			
			number[length] = i;
			if (required.contains(i)) 
				required_use[i]++;
			simulation(length+1);
			required_use[i]--;
		}
		
	}

}



