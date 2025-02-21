import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.lang.model.util.Elements;

public class Main {
	
	static int N;
	static HashSet<String> set = new HashSet<String>(); 
	static ArrayList<String> all_list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 20; i++) {
			all_list.add(i + "");
		}
		

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String order = st.nextToken();
			
			switch(order) {
			case "add":
				set.add(st.nextToken());
				break;
				
			case "remove":
				set.remove(st.nextToken());
				break;
				
			case "check":
				if (set.contains(st.nextToken()))
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
				
			case "toggle":
				String temp = st.nextToken();
				if(set.contains(temp))
					set.remove(temp);
				else
					set.add(temp);
				break;
				
			case "all":
				set.clear();
				set.addAll(all_list);
				break;
				
			case "empty":
				set.clear();
				break;
				
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}


