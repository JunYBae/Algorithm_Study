import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution {
	
	static int min, N, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());	
			}
		
			
			tracking_Ingredient(0, 0, 0); 	
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void tracking_Ingredient(int vertex, int select, int length) {
		
		if (length == N/2) {			
			int temp = calculate(select);
			if(temp < min)
				min = temp;		
			return;
		}
		
		
		for (int index = vertex; index < N; index++) {		
			if ((select & (1<<index)) == 0) {				
				tracking_Ingredient(index+1, select | 1 << index, length+1);				
			}			
		}
	}

	public static int calculate(int select) {
		
		ArrayList<Integer> a_list = new ArrayList<>();
		ArrayList<Integer> b_list = new ArrayList<>();
		
		int a_ingredient = 0, b_ingredient = 0;
		
		for (int index = 0; index < N; index++) {
			
			if ((select & (1 << index)) != 0) {
				a_list.add(index);
			} else {
				b_list.add(index);
			}
		}
		
		a_ingredient = real_calculate(a_list);
		b_ingredient = real_calculate(b_list);
		
		return Math.abs(a_ingredient - b_ingredient);
		
	}
	
	public static int real_calculate(ArrayList<Integer> list) {
		
		int sum = 0;
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				sum += arr[list.get(i)][list.get(j)] + arr[list.get(j)][list.get(i)];
			}
		}
		return sum;
	}
}

