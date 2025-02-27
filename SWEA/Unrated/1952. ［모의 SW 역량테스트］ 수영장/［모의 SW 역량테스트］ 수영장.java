import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	static int min, cost[], month[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			cost = new int[4]; // 1일, 1달, 3달, 1년 이용권 비용
			month = new int[13]; // 0 인덱스 버리고, 1~12 인덱스 사용
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++)
				cost[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++)
				month[i] = Integer.parseInt(st.nextToken());
			
			min = cost[3];
			backTracking(1, 0);
			
			// 출력 값 버퍼에 저장
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		// 출력 
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int cur_month, int total) {
		
		if (min < total)
			return;
		
		if (cur_month > 12) {
			if (min > total)
				min = total;
			return;
		}
		
		if (month[cur_month] == 0) {
			backTracking(cur_month+1, total);
		}
		
		else {
			backTracking(cur_month+1, total + (month[cur_month] * cost[0]));
			backTracking(cur_month+1, total + cost[1]);
			backTracking(cur_month+3, total + cost[2]);
		}
	}
}

