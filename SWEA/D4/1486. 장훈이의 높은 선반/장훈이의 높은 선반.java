import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, B, min, arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 사람 수
			B = Integer.parseInt(st.nextToken()); // 탑 높이 
			arr = new int[N]; // 배열 생성
			min = Integer.MAX_VALUE; // min 값 최대로 
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) { // 키 cm 저장 
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			tracking_height(0, 0); // 부분조합 + 백트래킹
			sb.append("#").append(test_case).append(" ").append((min - B)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void tracking_height(int vertex, int height) {
		
		if (B <= height) { // 만약 B보다 높아지면,
			if (min > height) // 그리고 min보다 현재 height가 작을 때
				min = height; // min 업데이트
			return;
		}
		
		for (int i = vertex; i < N; i++) { // 부분 조합 형식
			tracking_height(i+1, height + arr[i]); 
		}
	}
}
