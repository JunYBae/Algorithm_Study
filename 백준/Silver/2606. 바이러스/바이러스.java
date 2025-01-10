import java.util.Scanner;

class Main {
	
	static int map[][];
	static boolean visit[];
	static int vertex;
	static int edge;
	static int worm = -1;
	
	
	public static void depthFirstSearch(int v) {
		
		visit[v] = true;
		worm++;
		
		for(int i = 1; i <= vertex; i++)
		{
			if ((map[v][i] == 1 || map[i][v] == 1) && !visit[i]) 
			{
				depthFirstSearch(i);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		vertex = sc.nextInt();
		edge = sc.nextInt();
		
		map = new int[vertex+1][vertex+1];
		visit = new boolean[vertex+1];
		
		for (int i = 0; i < edge; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = 1;
		}
		
		depthFirstSearch(1);
		System.out.println(worm);
	}
}