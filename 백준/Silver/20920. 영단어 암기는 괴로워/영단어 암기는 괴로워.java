import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Content implements Comparable<Content> {
	String str;
	int count;
	
	Content(String str) {
		this.str = str;
		this.count = 1;
	}

	@Override
	public int compareTo(Content o) {
		if (this.count - o.count != 0) 
			return (this.count - o.count) * -1;
		else if (str.length() != o.str.length())
			return (this.str.length() - o.str.length()) *-1;
		else return str.compareTo(o.str);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Content) {
			Content other = (Content)obj;
			return other.str.equals(this.str);
		}
		return false;
	}
 }

public class Main {
	

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Content> map = new HashMap<>();
		PriorityQueue<Content> queue = new PriorityQueue<>();
		
		for (int index = 0; index < N; index++) {
			
			String str = br.readLine();
			
			if (str.length() < M)
				continue;
			
			Content content = new Content(str);
			
			if (map.containsKey(str)) {
				map.get(str).count++;
			}
			
			else {
				map.put(str, content);
			}	
		}
			
		Set<String> keyset = map.keySet();
		
		for (String key : keyset) {
			queue.add(map.get(key));
		}
		
		while(!queue.isEmpty()) {
			Content content = queue.poll();
			sb.append(content.str).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	 
}

