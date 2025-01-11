import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	boolean visit;
	ArrayList<Integer> edge;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		visit = false;
		edge = new ArrayList<>();
	}
}

class Main {
	
	static int N;
	static Point array_point[];
	static boolean success;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			array_point = new Point[N+2];
			success = false;
			
			for (int i = 0; i < N+2; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				array_point[i] = new Point(x, y);
			}
			
			connect_vertex();
			DFS(array_point[0]);
			
			if (success)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
		
	}
	
	public static void connect_vertex() {
		for (int i = 0; i < array_point.length; i++)
		{
			Point point_1 = array_point[i];
			
			for (int j = 1+i; j < array_point.length; j++)
			{
				Point point_2 = array_point[j];
				
				if (Math.abs(point_2.x - point_1.x)
						+ Math.abs(point_2.y - point_1.y) <= 1000) {
					point_1.edge.add(j);
					point_2.edge.add(i);
				}
			}
		}
	}
	
	public static void DFS(Point point) {
		
		point.visit = true;
		
		if (point.equals(array_point[N+1])) {
			success = true;
			return;
		}
		
		for (int i = 0; i < point.edge.size(); i++)
		{
			int edge = point.edge.get(i);
			
			if (array_point[edge].visit == false)
				DFS(array_point[point.edge.get(i)]);
		}
	}
}


