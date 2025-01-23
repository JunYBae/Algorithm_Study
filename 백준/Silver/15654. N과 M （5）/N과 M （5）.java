import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static int N, M, array[], answer[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[N];
		answer = new int[M];
		visit = new boolean[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		
		Arrays.sort(array);
		DFS(0, 0);
		
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (M == depth) {
			for (int number : answer)
				System.out.print(number + " ");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = array[i];
				DFS(i, depth+1);
				visit[i] = false;
			}
		}
	}
}














