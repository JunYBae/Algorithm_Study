import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, answer, map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" "); // 답 출력하기 위해서 적었습니다.
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵크기
			M = Integer.parseInt(st.nextToken()); // 파리약 범위
			answer = 0; // 답
			map = new int[N][N]; // 맵 배열 
		
			for (int i = 0; i < N; i++) { // 맵 저장
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x <= N - M; x++) { // 0~N-M 까지 x 범위
				for (int y = 0; y <= N - M; y++) { // 0~N-M 까지 y 범위
					remove_pari(x, y); 
				}
			}
			
			
			sb.append(answer).append("\n"); // 정답 붙이기
		}
		System.out.println(sb.toString()); // 모아놨던 정답들 출력
	}
	
	// 파리를 잡아보자
	public static void remove_pari(int x, int y) {
		
		int cur_sum = 0;
		
		for (int i = 0; i < M; i++) { // x좌표에다 더해줄 i 변수 -> 이걸 M까지
			for (int j = 0; j < M; j++) {
				
				int cur_x = x + i;
				int cur_y = y + j;
				
				cur_sum += map[cur_x][cur_y];
			}
		}
		
		
		if(answer < cur_sum) // 기존 값보다 더 많이 잡을 수 있으면 바꿔줌
			answer = cur_sum;
	}
}

