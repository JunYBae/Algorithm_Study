import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, array[];
	
	public static void main(String[] args) throws IOException {
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[M];
		
		backTracking(1, 0);
		bw.flush();
	}
	
	public static void backTracking(int vertex, int depth) throws IOException {
		
		if (depth == M) {
			bw.write(Arrays.toString(array)
					.replaceAll("[\\[,\\]]", ""));
			bw.newLine();
			return;
		}
		
		for (int i = vertex; i <= N; i++) {
			array[depth] = i;
			backTracking(i, depth+1);
		}
	}
}