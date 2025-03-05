import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x ,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	static int N, answer;
	static Point company, home;
	static ArrayList<Point> customer_list;	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			customer_list = new ArrayList<Point>();
			answer = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++)
				customer_list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

			

			boolean visit[] = new boolean[N];
			simulation(company, 0, 0, visit);

			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void simulation(Point prev, int vertex, int length, boolean visit[]) {
		
		if (answer < length)
			return;
		
		if (vertex == N) {
			int temp = Math.abs(home.x - prev.x) + Math.abs(home.y - prev.y);
			if (temp + length < answer)
				answer = temp + length;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				Point customer = customer_list.get(i);
				int temp = Math.abs(prev.x - customer.x) + Math.abs(prev.y - customer.y);
				simulation(customer, vertex+1, length+temp, visit);
				visit[i] = false;
			}
		}
	}
}









