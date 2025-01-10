import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	static ArrayList<Integer> queue = new ArrayList<>();
	static int map[][];
	static boolean visit[];
	static int vertex;
	static int edge;
	static int start;
	
	public static void DFS(int v) {
		
		visit[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= vertex; i++) 
		{
			if ((map[v][i] == 1 || map[i][v] == 1) && !visit[i])
			{
				DFS(i);
			}
		}
	}
	
	public static void BFS(int v) {
		
		visit[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= vertex; i++)
		{
			if((map[v][i] == 1 || map[i][v] == 1) && !visit[i])
			{
				queue.add(i);
				visit[i] = true;
			}
		}
		
		if (!queue.isEmpty())
			BFS(queue.remove(0));
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		vertex = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();
		
		map = new int[vertex+1][vertex+1];
		visit = new boolean[vertex+1];
		
		for (int i = 0; i < edge; i++) 
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = 1;
		}
		
		DFS(start);
		
		for (int i = 0; i < vertex+1; i++)
		{
			visit[i] = false;
		}
		
		System.out.println();
		
		BFS(start);
	}
}