import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int N;
	static HashMap<String, ArrayList<String>> edge_list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		edge_list = new HashMap<>();
		
		for (int i = 0; i < N; i++) 
			edge_list.put(Character.toString((char) ('A' + i)), new ArrayList<>());		
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String start = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			edge_list.get(start).add(left);
			edge_list.get(start).add(right);
		}

		first_search("A");
		sb.append("\n");
		middle_search("A");
		sb.append("\n");
		last_search("A");

		System.out.println(sb.toString());
	}

	public static void first_search(String start) {
		
		if(start.equals("."))
			return;
		
		ArrayList<String> next_edge = edge_list.get(start);
		
		sb.append(start);
		first_search(next_edge.get(0));		
		first_search(next_edge.get(1));
		
			
	}
	public static void middle_search(String start) {
			
		if(start.equals("."))
			return;
		
		ArrayList<String> next_edge = edge_list.get(start);
		
		middle_search(next_edge.get(0));
		sb.append(start);
		middle_search(next_edge.get(1));
		
	}
	public static void last_search(String start) {
		
		if(start.equals("."))
			return;
		
		ArrayList<String> next_edge = edge_list.get(start);
		
		last_search(next_edge.get(0));
		last_search(next_edge.get(1));
		sb.append(start);
	}
}

