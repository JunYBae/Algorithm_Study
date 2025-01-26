
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	
	public static int array[], N, M;
	public static boolean visit[];
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[N];
		visit = new boolean[N];
		int answer[] = new int[M];
		
		for (int i = 0; i < N; i++) 
			array[i] = sc.nextInt();
		
		Arrays.sort(array);
		
		DFS(0, answer, 0);
		
		for (String number : set)
			System.out.println(number);
	}
	
	public static void DFS(int vertex, int answer[], int depth) {
		
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			
			for (int number : answer)
				sb.append(number + " ");
			set.add(sb.toString());
			
			return;
		}
		
		for (int i = vertex; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = array[i];
				DFS(i, answer, depth+1);
				visit[i] = false;
			}
		}
	}
}

