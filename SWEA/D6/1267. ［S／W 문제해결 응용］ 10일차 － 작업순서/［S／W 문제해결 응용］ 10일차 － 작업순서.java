import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int value; // 이건 현재 노드의 값임 
	ArrayList<Integer> edge = new ArrayList<Integer>(); // 현재 연결되어 있는 노드 값
	
	Node(int value) {
		this.value = value;
	}
	
	Node(int value, int edge) {
		this.value = value;
		this.edge.add(edge);
	}
	
	public int edge_size() {
		return edge.size();
	}
}

public class Solution {
	
	static int V, E;
	static Node map[];
	static int node_connect_size[]; // 각 노드들이 연결되어 있는 개수 ?
	static ArrayDeque<Node> queue; // 노드들 넣는 큐 (참조없는 노드들)
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken()); // 정점의 개수 
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			map = new Node[V+1]; // 이건 현재 인덱스의 노드를 저장 
			node_connect_size = new int[V+1]; // 각 노드들이 연결되어 있는 개수 ?
			queue = new ArrayDeque<>(); // 노드들을 저장 
			
			for (int i = 1; i <= V; i++)
				map[i] = new Node(i); // 초기화
			
			st = new StringTokenizer(br.readLine(), " "); 
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken()); // 시작노드
				int end = Integer.parseInt(st.nextToken()); // 도착 노드
				
				node_connect_size[end]++; // 도착노드의 참조 노드 개수 추가				
				map[start].edge.add(end);
			}
			
			for (int i = 1; i <= V; i++) {
				if (node_connect_size[i] == 0) // 만약 루트(루트는 아니지만) 노드이면?
					queue.add(map[i]); // 넣어주기 
			}
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("#" + test_case +" "); // 처음 출력 초기화
			progress_task(sb); // 일처리 시작 
			 
			System.out.println(sb.toString()); // 결과 출력
		}
	}
	
	
	public static void progress_task(StringBuilder sb) {
		
		while(!queue.isEmpty()) { // 큐가 빌때 까지 진행
			
			Node cur_node = queue.poll(); // 현재 마지막 노드 뺌 
			sb.append(cur_node.value + " "); // 현재 노드 값 넣어줌
			
			ArrayList<Integer> cur_edge = cur_node.edge; // 현재 노드와 연결되어있는 노드들
			
			while(!cur_edge.isEmpty()) { // 연결되어 있는 노드들 찾아서 edge 제거
				int temp_edge = cur_edge.remove(0);
				node_connect_size[temp_edge]--;
				
				if(node_connect_size[temp_edge] == 0) { // 만약 나를 참조하는 노드가 없으면?
					queue.add(map[temp_edge]); // 노드 넣어주기
				}
			}
		}

	}
}
