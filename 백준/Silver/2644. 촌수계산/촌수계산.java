import java.util.Scanner;

class Main {
	
	static int vertex, edge;
	static int start, end, minEdge;
	static int map[][];
	static boolean visit[];
	
	public static void DFS(int v, int depth) {
		
		if (v == end) {
			if (minEdge < 0 || depth < minEdge) {
				minEdge = depth;
			}
		}
		
		visit[v] = true;
		
		for (int i = 1; i <= vertex; i++)
		{
			if ((map[v][i] == 1 || map[i][v] == 1) && !visit[i]) {
				DFS(i, depth+1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt(); 
		start = sc.nextInt();
		end = sc.nextInt();
		edge = sc.nextInt();
		
		map = new int[vertex+1][vertex+1];
		visit = new boolean[vertex+1];
		minEdge = -1;
		
		for (int i = 0; i < edge; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = 1;
		}
		
		DFS(start, minEdge);
		
		if (minEdge != -1)
			minEdge++;
		
		System.out.println(minEdge);

	}
}