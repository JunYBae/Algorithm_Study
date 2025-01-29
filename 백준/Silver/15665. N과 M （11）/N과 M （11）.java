import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

class Main {
	
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static int array[], answer[], N, M;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N];
		answer = new int[M];
		
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		
		Arrays.sort(array);
		
		DFS(0);
		
		for (String number : set)
			bw.write(number + "\n");
		bw.flush();
	}
	
	public static void DFS(int depth) {
		
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int number : answer)
				sb.append(number + " ");
			set.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			answer[depth] = array[i];
			DFS(depth+1);
		}
	}
}