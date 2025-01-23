import java.util.Arrays;
import java.util.Scanner;

class Solution {

	static int N, B, min_height, list[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			B = sc.nextInt();
			
			list = new int[N];
			visit = new boolean[N];
			min_height = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++)
				list[i] = sc.nextInt();
			
			backTracking(0, 0);
			
			System.out.println("#" + test_case + " " + (min_height - B));
		}
	}
	
	public static void backTracking(int vertex, int depth) {
		
		if (depth >= B) {

			if (depth < min_height)
				min_height = depth;
			return;
		}
		
		for (int index = vertex; index < N; index++) {
			if (!visit[index]) {
				visit[index] = true;
				backTracking(index, depth+list[index]);
				visit[index] = false;
			}
		}	
		
	}
}