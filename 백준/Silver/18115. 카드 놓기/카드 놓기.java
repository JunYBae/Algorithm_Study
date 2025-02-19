import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		Deque<Integer> list = new ArrayDeque<>();
		
		int index = 1;
		
		for (int i = str.length-1; i >= 0; i--) {
			switch(str[i]) {
			case "1":
				list.addFirst(index);
				break;				
			case "2":
				int temp = list.removeFirst();
				list.addFirst(index);
				list.addFirst(temp);
				break;
			case "3":
				list.addLast(index);
				break;
			}
				
			index++;
		}
			
		while (!list.isEmpty()) {
			sb.append(list.removeFirst()).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}