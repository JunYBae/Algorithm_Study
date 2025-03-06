import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
	int num;
	LinkedList<Node> edge;
	Node(int num) {
		this.num = num;
		edge = new LinkedList<>();
	};
}

public class Main {
	
	static int N, M, cut, answer;
	static ArrayList<Node> Node_list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Node_list = new ArrayList<>();
		answer = 0;
		int root_node_num = -1;
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int index = 0; index < N; index++)
			Node_list.add(new Node(index));
		
		for (int index = 0; index < N; index++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(temp == -1) {
				root_node_num = index;
				continue;
			}
				
			Node_list.get(temp).edge.add(Node_list.get(index));
		}		
		cut = Integer.parseInt(br.readLine());
		
		if (cut == root_node_num) {
			System.out.println("0");
			return;
		}
		
		for (int index = 0; index < N; index++) {
			if (Node_list.get(index).edge.contains(Node_list.get(cut))) {
				Node_list.get(index).edge.remove(Node_list.get(cut));
			}
		}
		
		DFS(Node_list.get(root_node_num));
		System.out.println(answer);
	}
	
	public static void DFS(Node node) {
		
		if (node.edge.size() == 0) {
			answer++;
			return;
		}
		
		for (Node next_node : node.edge) {
			DFS(next_node);
		}
	}

}







