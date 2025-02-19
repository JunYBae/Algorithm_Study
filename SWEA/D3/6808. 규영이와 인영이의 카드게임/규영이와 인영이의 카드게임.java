import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer> list_a; 
	static ArrayList<Integer> list_b;
	
	static int win, lose;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			list_a = new ArrayList<>();
			list_b = new ArrayList<>();
			visit = new boolean[9];
			win = 0;
			lose = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 9; i++) { // 값 받기 
				list_a.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 1; i <= 18; i++) {
				if (!list_a.contains(i))
					list_b.add(i);
			}
				
			simulation(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(win)
			.append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation(int vertex, int score_a, int score_b) {
		
		if(vertex == 9) {
			if (score_a > score_b)
				win++;
			else if (score_a < score_b)
				lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			
			if (!visit[i]) {
				
				visit[i] = true;
				if (list_a.get(vertex) < list_b.get(i)) {
					simulation(vertex+1, score_a, score_b + list_a.get(vertex) + list_b.get(i));
				} else if (list_a.get(vertex) > list_b.get(i)) {
					simulation(vertex+1, score_a + list_a.get(vertex) + list_b.get(i), score_b);
				} else {
					simulation(vertex+1, score_a, score_b);
				}
				visit[i] = false;
				
			}
		}	
		
	}
}
