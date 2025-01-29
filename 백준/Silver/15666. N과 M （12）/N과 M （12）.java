import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class Main {
	
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static int array[], answer[], N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(array);
		
		DFS(0, 0);
		
		for (String number : set)
			bw.write(number + "\n");
		bw.flush();
	}
	
	public static void DFS(int vertex, int depth) {
		
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int number : answer)
				sb.append(number + " ");
			set.add(sb.toString());
			return;
		}
		
		for (int i = vertex; i < N; i++) {
			answer[depth] = array[i];
			DFS(i, depth+1);
		}
	}
}