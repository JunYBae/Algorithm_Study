import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	static int N, M;
	static int array[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[M];
		
		backTracking(0);
		bw.flush();
	}
	
	public static void backTracking(int depth) throws IOException {
		
		if (depth == M) {
			bw.write(Arrays.toString(array).replace("[", "")
					.replace(",", "").replace("]", "\n"));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			array[depth] = i;
			backTracking(depth+1);
		}
	}
}