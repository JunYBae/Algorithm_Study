import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	static int N, S, array[], answer[], count;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		array = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		backTracking(-1, 0);
		
		bw.write(count +"\n");
		bw.flush();
	}
	
	public static void backTracking(int vertex, int sum) {
		
		if (vertex != - 1 && sum == S) {
			count++;
		}
		
		for (int i = vertex+1; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				backTracking(i, sum + array[i]);
				visit[i] = false;
			}
		}
	}
	
}
