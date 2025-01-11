import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N, K, count;
	static boolean visit[] = new boolean[100001];
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if (N == K) {
			System.out.print(0);
			return;
		}
		
		count = 0;
		queue.add(N);
		
		BFS();
		
		System.out.println(count);
	}
	
	public static void BFS() {
		
		while(!queue.isEmpty()) 
		{	
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++)
			{
				int temp = queue.poll();
				
				if(temp == K)
					return;
				
					if (temp - 1 >= 0 && !visit[temp - 1]) {
						visit[temp - 1] = true;
						queue.add(temp - 1);
					}
					if (temp + 1 <= 100000 && !visit[temp + 1]) {
						visit[temp + 1] = true;
						queue.add(temp + 1);
					}
					if (temp * 2 <= 100000 && !visit[temp * 2]) {
						visit[temp * 2] = true;
						queue.add(temp * 2);
					}
				}			
				count++;
			}
						
		}
}