import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int N, M ,array[], answer[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[N];
		answer = new int[M];
		
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		
		Arrays.sort(array);
		
		DFS(-1, 0);
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (depth == M) {
			for (int number : answer)
				System.out.print(number + " ");
			System.out.println();
			return;
		}
		
		for (int index = vertex+1; index < N; index++) {
			answer[depth] = array[index];
			DFS(index, depth+1);
		}
	}
}




