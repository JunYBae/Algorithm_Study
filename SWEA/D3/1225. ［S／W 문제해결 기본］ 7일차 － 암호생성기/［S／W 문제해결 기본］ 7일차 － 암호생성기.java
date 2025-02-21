import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		for (int test_case = 1; test_case <= 10; test_case++) { // 10번 반복 

			int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			StringTokenizer st = new StringTokenizer(br.readLine()); // 숫자들 읽기 (" " 파싱처리)
			ArrayDeque<Integer> queue = new ArrayDeque<>(); // 숫자를 저장할 deque 생성
			
			for (int i = 0; i < 8; i++) 
				queue.add(Integer.parseInt(st.nextToken())); // queue에 숫자들 집어 넣기
			
			int index = 1; // 사이클에서 빼줄 숫자 
			int cur_num = 0; // 현재 숫자 저장할 변수
			while((cur_num = queue.poll() - index) > 0) { // queue에서 숫자하나 빼서 index 빼줬을 때 0보다 크면 반복
				queue.add(cur_num); // 뺀수 다시 뒤에 넣기 
				
				index = (index % 5) + 1; // 1.2.3.4.5 -> 1.2.3.4.5 반복
			}
			
			queue.addLast(0); // 마지막에 0 넣기 
		
			// 출력부분입니다.
			sb.append("#").append(test_case).append(" ");
			while (!queue.isEmpty()) 
				sb.append(queue.poll()).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

