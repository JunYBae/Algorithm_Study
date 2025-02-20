import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 15650번: N과 M(2) */
public class Main {
	
	static int N, M, answer[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 숫자 개수 
		M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		answer = new int[N]; // 숫자 누적합 저장할 배열 생성
		
		st = new StringTokenizer(br.readLine(), " ");
		answer[0] = Integer.parseInt(st.nextToken()); // 숫자 초기 하나 저장해놓음
		
		for (int i = 1; i < N; i++) { 
			answer[i] = answer[i-1] + Integer.parseInt(st.nextToken()); // 누적합 만들기
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int temp = 0;
			
			if (start == 1)
				temp = answer[end-1];
			
			else
				temp = answer[end-1] - answer[start-2];
			
			sb.append(temp).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}



