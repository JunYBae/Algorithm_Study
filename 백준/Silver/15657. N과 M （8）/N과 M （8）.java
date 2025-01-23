import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
	
	static int N, M, array[], answer[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[N];
		answer = new int[M];
		
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		
		Arrays.sort(array);
		DFS(0, 0);
		
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (depth == M) {
			for (int number : answer)
				System.out.print(number + " ");
			System.out.println();
			return;
		}
		
		for (int i = vertex; i < N; i++) {
			answer[depth] = array[i];
			DFS(i, depth+1);
		}
	}
}














