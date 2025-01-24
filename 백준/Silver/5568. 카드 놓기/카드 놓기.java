import java.util.HashSet;
import java.util.Scanner;

class Main {
	
	static int array[], answer[]; // 담을 배열들
	static int T, K; // 개수, 뽑을 갯수
	static boolean visit[]; // 방문 여부 
	static HashSet<String> set = new HashSet<>(); // 숫자 중복 방지 위한 저장소
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		K = sc.nextInt();
		
		array = new int[T];
		visit = new boolean[T];
		answer = new int[K];
		
		for (int index = 0; index < T; index++)
			array[index] = sc.nextInt();
		
		DFS(0);
		
		System.out.println(set.size());
	}
	
	public static void DFS(int depth) {
		
		if (depth == K) {
			StringBuilder st_builder = new StringBuilder();
			for (int i = 0; i < answer.length; i++)
				st_builder.append(answer[i]);
			set.add(st_builder.toString());
			return;
		}
		
		for (int i = 0; i < T; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = array[i];
				DFS(depth+1);
				visit[i] = false;
			}
		}
		
		
	}
}