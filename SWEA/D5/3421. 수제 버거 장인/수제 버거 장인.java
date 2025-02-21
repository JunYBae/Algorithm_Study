import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;



public class Solution {
	
	static int N, M, answer;
	static ArrayList<HashSet<Integer>> no_list; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		for (int test_case = 1; test_case <= T; test_case++) { // 테스트 케이스 만큼 반복 
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 재료들 개수  
			M = Integer.parseInt(st.nextToken()); // 궁합이 안맞는 친구들 개수
			no_list = new ArrayList<>();
			answer = 0;
			
			for (int i = 0; i <= N; i++) {
				no_list.add(new HashSet<Integer>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken()); // 안맞는 애들 1
				int end = Integer.parseInt(st.nextToken()); // 안맞는 애들 2
				no_list.get(start).add(end); // 서로 안맞기에 둘다 넣음
				no_list.get(end).add(start); // 서로 안맞기에 둘다 넣음
			}
			
			simulation(1, new ArrayList<Integer>()); 

			sb.append("#").append(test_case).append(" ").append(answer).append("\n"); // 최종 결과 저장
		}
		
		System.out.println(sb.toString()); // 모든 결과 출력 
	}
	
	public static void simulation(int vertex, ArrayList<Integer> ingredient) {
			
		if (vertex == N+1) {
			answer++; // 모두 다 돌았으면 경우의수 하나 추가
			return;
		}
		
		// 실제로 궁합이 맞지 않는 친구들이 미리 안에 없는지 있는지.
		boolean check = true;
		for (int ingre : ingredient) { // 현재 재료들 하나씩 돌림
			if (no_list.get(vertex).contains(ingre)) { // 만약 현재 재료들에 궁합 안맞는 친구들 있니?
				check = false; // 있으면 check = false
				break; 
			}
		}
		
		if (check) { // 없으면 넣음
			ingredient.add(0, vertex); // 재료들 리스트에 넣기 
			simulation(vertex+1, ingredient); // 재귀 호출
			ingredient.remove(0); // 재료들 리스트에서 빼주기 
		}
		// 그냥 안넣음
		simulation(vertex+1, ingredient);  // 재귀 호출
	
	}
}


