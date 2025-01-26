
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	
	static int array[], N, M;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) 
			array[i] = sc.nextInt();
		
		int answer[] = new int[M];
		
		Arrays.sort(array);
		
		DFS(answer, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void DFS(int answer[], int depth) {
		
		if (M == depth) {
		
			for (int number : answer)
				sb.append(number + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			answer[depth] = array[i];
			DFS(answer, depth+1);
		}
	}
}
