import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean success;
	static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String start = st.nextToken();
			st.nextToken();
			String end = st.nextToken();
			map.put(start, end);
		}
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String start = st.nextToken();
			st.nextToken();
			String end = st.nextToken();
			
			success = false;
			DFS(start, end, sb);
			
			if(!success)
				sb.append("F").append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void DFS(String start, String end, StringBuilder sb) {
		
		if (start.equals(end)) {
			success = true;
			sb.append("T").append("\n");
			return;
		}
		
		if (map.containsKey(start))
			DFS(map.get(start), end, sb);
	}

}


