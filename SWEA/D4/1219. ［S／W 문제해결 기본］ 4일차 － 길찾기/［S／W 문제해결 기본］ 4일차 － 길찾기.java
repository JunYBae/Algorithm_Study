import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	
	static Stack<Integer> stack;
	static List<Integer> list[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++)
		{
			int test_number = sc.nextInt();
			int edge_size = sc.nextInt();
			
			init();
			insert_Edge(sc, edge_size);
			boolean success = DFS(0);
			
			System.out.println("#" + test_number + " " + (success ? 1 : 0));
		}
	}
	
	public static boolean DFS(int start) {
		
		stack.add(start);
		
		while(!stack.isEmpty()) {
			
			int cur_node = stack.pop();
			
			if (visit[cur_node])
				continue;
			
			if (cur_node == 99)
				return true;
			
			visit[cur_node] = true;
			
			for (int next_node : list[cur_node]) {
				if (!visit[next_node])
					stack.add(next_node);
			}

		}
		
		return false;
	}
	
	public static void insert_Edge(Scanner sc, int size) {
		
		for (int i = 0; i < size; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list[start].add(end);
		}
			
	}
	
	public static void init() {
		stack = new Stack<>();
		list = new LinkedList[100];
		visit = new boolean[100];
		
		for (int i = 0; i < 100; i++)
			list[i] = new LinkedList<>();
	}
}