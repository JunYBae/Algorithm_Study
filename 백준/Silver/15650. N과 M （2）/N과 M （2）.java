import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* 15650번: N과 M(2) */
public class Main {
	
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 자연수  
		M = Integer.parseInt(st.nextToken()); // 수열 길이 
		arr = new int[M];
		
		combination(1, 0);
		System.out.println(sb.toString());
	}
	
	public static void combination(int vertex, int length) {
		
		if (length == M) {
			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = vertex; i <= N; i++) {
			arr[length] = i;
			combination(i+1, length+1);
		}
	}
}


