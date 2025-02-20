import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/* 5215. 햄버거 다이어트 */
class Ingredient implements Comparable<Ingredient> {
	int score, kcal, differ;
	
	Ingredient(int score, int kcal) {
		this.score = score;
		this.kcal = kcal;
		this.differ = this.kcal - this.score;
	}

	@Override
	public int compareTo(Ingredient o) {
		return Integer.compare(this.kcal, o.kcal);
	}
}

public class Solution {
	
	static int N, L, kcal_arr[];
	static ArrayList<Ingredient> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" "); // 답 출력하기 위해서 적었습니다.
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			kcal_arr = new int[L+1]; // 해당 배열인덱스에 해당하는 칼로리에서 얻을 수 있는 점수 저장
			
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken()); // 점수
				int kcal = Integer.parseInt(st.nextToken()); // 칼로리
				list.add(new Ingredient(score, kcal));
			}
			
			Collections.sort(list);
			
			for (Ingredient ingredient : list) {
				
				for (int cur_kcal = L; cur_kcal >= ingredient.kcal; cur_kcal--) {
					
					 kcal_arr[cur_kcal] = Math.max(kcal_arr[cur_kcal], 
							 kcal_arr[cur_kcal-ingredient.kcal] + ingredient.score);
					
				}
				
			}
			
			sb.append(kcal_arr[L]).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}






// 그리디로 풀어봤지만, 12개만 맞아서 DP로 변경 

//class Ingredient implements Comparable<Ingredient> {
//	int score, kcal, differ;
//	
//	Ingredient(int score, int kcal) {
//		this.score = score;
//		this.kcal = kcal;
//		this.differ = this.kcal - this.score;
//	}
//
//	@Override
//	public int compareTo(Ingredient o) {
//		return Integer.compare(this.differ, o.differ);
//	}
//	
//}
//
//public class Solution {	
//	
//	static int N, L;
//	static ArrayList<Ingredient> list;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
//		for (int test_case = 1; test_case <= T; test_case++) {
//			
//			sb.append("#").append(test_case).append(" "); // 답 출력하기 위해서 적었습니다.
//			
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			N = Integer.parseInt(st.nextToken()); // 재료의 수
//			L = Integer.parseInt(st.nextToken()); // 제한 칼로리 
//			
//			list = new ArrayList<>();
//			
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				int score = Integer.parseInt(st.nextToken()); // 점수
//				int kcal = Integer.parseInt(st.nextToken()); // 칼로리
//				list.add(new Ingredient(score, kcal));
//			}
//			
//			Collections.sort(list); // 가장 둘의 차가 적은 애들이 먼저 나오도록 정렬
//			
//			int cur_score = 0, cur_kcal = 0;
//			while (!list.isEmpty()) {
//				
//				Ingredient ingredient = list.remove(0);
//				
//				if (cur_kcal + ingredient.kcal > L)
//					break;
//				
//				cur_kcal = cur_kcal + ingredient.kcal;
//				cur_score = cur_score + ingredient.score;
//			}
//			
//			sb.append(cur_score).append("\n");
//		}
//		System.out.println(sb.toString()); // 모아놨던 정답들 출력
//	}
//	
//}


