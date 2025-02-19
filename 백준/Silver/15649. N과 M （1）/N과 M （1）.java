import java.util.Scanner;

public class Main {
	
	static int N, M, arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visit = new boolean[N+1];
		
		dfs(0, 0);
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	public static void dfs(int vertex, int length) {
		
		if (length == M) {
			print_arr();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			
			if (!visit[i]) {
				visit[i] = true;
				arr[length] = i;
				dfs(i, length+1);
				visit[i] = false;
			}
		}
	}
	
	
	public static void print_arr() {
		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i]).append(" ");
		sb.append("\n");
	}
}
