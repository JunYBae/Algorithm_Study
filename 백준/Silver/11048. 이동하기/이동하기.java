import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x,  y, candy;
	Point(int x, int y, int candy) {
		this.x = x;
		this.y = y;
		this.candy = candy;
	}
	@Override
	public int compareTo(Point o) {
		return Integer.compare(candy, o.candy) * -1;
	}
	
}

public class Main {
	
	static int N, M;
	static int arr[][], cost[][];
	static int dir[][] = {{-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		cost = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		cost[0][0] = arr[0][0];
		
		for (int i = 1; i < N; i++) 
			cost[i][0] = cost[i-1][0] + arr[i][0];
		for (int i = 1; i < M; i++)
			cost[0][i] = cost[0][i-1] + arr[0][i];
		
		best_route_find();
		
		System.out.println(cost[N-1][M-1]);
	}
	
	public static void best_route_find() {
		
		for (int x = 1; x < N; x++) {
			for (int y = 1; y < M; y++) {				
				int sel_cost = cost[x-1][y] > cost[x][y-1] ? cost[x-1][y] : cost[x][y-1];
				cost[x][y] = sel_cost + arr[x][y];			
			}
		}	
	}

}


