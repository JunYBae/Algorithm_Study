import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Node {
	int vertex;
	HashSet<Integer> edge_list = new HashSet<>();
	Node(int vertex) {
		this.vertex = vertex;
	}
}

public class Solution {
	
	static int V, E, map[];
	static Node node_list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			sb.append("#").append(test_case).append(" ");
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			map = new int[V+1];
			node_list = new Node[V+1];
			
			for (int i = 1; i <= V; i++) {
				node_list[i] = new Node(i);
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				map[end]++;
				node_list[start].edge_list.add(end);
			}
			
			ArrayDeque<Node> queue = new ArrayDeque<>();
			for (int i = 1; i <= V; i++) {
				if (map[i] == 0)
					queue.add(node_list[i]);
			}
			
			BFS(queue, sb);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void BFS(ArrayDeque<Node> queue, StringBuilder sb) {
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			sb.append(node.vertex).append(" ");
			
			for (int next_node : node.edge_list) {
				map[next_node]--;
				
				if (map[next_node] == 0)
					queue.add(node_list[next_node]);
			}
		}
	}
}


