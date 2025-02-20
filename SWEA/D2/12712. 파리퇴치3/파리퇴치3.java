import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, answer, map[][];
	static int p_dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int x_dir[][] = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
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
			
			
			for (int x = 0; x < N; x++) { // x, y 좌표마다,  + 방향 x 방향으로 얼마나 잡을 수 있는 지 시뮬레이션
				for (int y = 0; y < N; y++) { 
					simulation(x, y, p_dir);
					simulation(x, y, x_dir);
				}
			}
			
			sb.append(answer).append("\n"); // 정답 붙이기
		}
		System.out.println(sb.toString()); // 모아놨던 정답들 출력
	}
	
	public static void simulation(int x, int y, int dir[][]) {
		
		int cur_sum = map[x][y]; // 내가 있는 위치 파리 개수 저장
		
		for (int i = 0; i < dir.length; i++) { // 갈수 있는 방향 만큼 반복
			
			int index = 1; // 이건 파리 약이 강도세기때문에 선언해준 변수
			
			while(index < M) { // 세기만큼 반복
				
				int cur_x = x + dir[i][0] * index; // 곱해주는 형식
				int cur_y = y + dir[i][1] * index; // 곱해주는 형식
				
				if (!is_In(cur_x, cur_y)) // 죽이는 약 범위가 맵 안에 없으면 break
					break;
				
				cur_sum += map[cur_x][cur_y]; // 죽일 수 있으면 계속 누적합
				
				index++; 
			}
 			
		}
		
		if(answer < cur_sum) // 기존 값보다 현재값이 더 높으면 바꿔줌
			answer = cur_sum;
	}
	
	// x, y 좌표가 해당 맵 영역 안에 있으면 true, 아니면 false
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}

