import java.util.Scanner;

class Main {
	
	static int N, M, answer[];
	static boolean visit[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N+1];
		answer = new int[M];
		
		DFS(1, 0);
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (depth == M) {
			print_answer();
			return;
		}
		
		for (int i = vertex; i <= N; i++) {
			if (!visit[i]) 
			{
				answer[depth] = i;
				visit[i] = true;
				DFS(i, depth+1);
				visit[i] = false;
			}
		}
	}
	
	
	public static void print_answer() {
		for (int i = 0; i < M; i++) 
			System.out.print(answer[i] + " ");
		System.out.println();
	}
}