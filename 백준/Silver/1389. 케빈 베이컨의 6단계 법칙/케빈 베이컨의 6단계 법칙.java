import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N, M, min, result;
	static int map[][];
	static boolean visit[];
	
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++)
		{
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			map[temp1][temp2] = 1;
			map[temp2][temp1] = 1;
		}
		
		for (int i = 1; i <= N; i++) 
		{
			visit = new boolean[N+1];
			int sum = BFS(i);
			
			if (min > sum) {
				min = sum;
				result = i;
			}
		}
		
		System.out.println(result);
	}
	
	public static int BFS(int start) {
		
		int sum = 0;
		int distance[] = new int[N+1];
		visit[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) 
		{
			int temp = queue.poll();
			
			for (int i = 1; i <= N; i++) 
			{
				if (map[temp][i] == 1 && !visit[i]) 
				{
					visit[i] = true;
					distance[i] = distance[temp] + 1;
					queue.add(i);
				}
			}
		}
		
		for (int i = 1; i <= N; i++)
			sum += distance[i];
		
		return sum;
	}
}