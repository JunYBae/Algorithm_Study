import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution {
	
	static int N, number[], oper[];
	static int min, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
	
			N = Integer.parseInt(br.readLine());
			number = new int[N];
			oper = new int[4];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				oper[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				number[i] = Integer.parseInt(st.nextToken());
			
			tracking_calculate(0, new ArrayList<Integer>());
			
			sb.append("#").append(test_case).append(" ").append((Math.abs(min-max))).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void tracking_calculate(int length, ArrayList<Integer> list) {
		
		if (length == N-1) {
			calculate(list);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (oper[i] != 0) {
				oper[i]--;
				list.add(i);
				tracking_calculate(length+1, list);
				list.remove(list.size()-1);
				oper[i]++;
			}
		}
	}
	
	public static void calculate(ArrayList<Integer> list) {
		
		int sum = number[0];
		int index = 1;
		
		for (int oper : list) {
			
			switch(oper) {
			case 0:
				sum += number[index];
				break;
			case 1:
				sum -= number[index];
				break;
			case 2:
				sum *= number[index];
				break;
			case 3:
				sum /= number[index];
				break;
			}
			
			index++;
		}
		
		if (max < sum)
			max = sum;
		
		if (min > sum)
			min = sum;
	}
}





















