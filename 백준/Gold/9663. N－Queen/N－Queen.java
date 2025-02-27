import java.util.Scanner;

// N*N 판에 N개의 퀸을 양립하도록 놓기
public class Main {
	
	static int N, answer;
	static boolean[] col, slash_1, slash_2; // 같은 열, 대각선(/), 대각선(\)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new boolean[N+1];
		slash_1 = new boolean[2*N+1];
		slash_2 = new boolean[2*N];
		
		setQueens(0);
		System.out.println(answer);
	}
	
	static void setQueens(int rowNo) {
		
		if (rowNo == N) {
			answer++;
			return;
		}
		
		for (int c = 1; c <= N; c++) {
			if (isAvailable(rowNo, c)) {
				col[c] = slash_1[rowNo+c] = slash_2[(rowNo-c)+N] = true;
				setQueens(rowNo+1); // 다음 퀸 놓기
				col[c] = slash_1[rowNo+c] = slash_2[(rowNo-c)+N] = false;
			}
		}
	}
	
	static boolean isAvailable(int rowNo, int c) {
		return !col[c] && !slash_1[rowNo+c] && !slash_2[(rowNo-c)+N];
	}
}
