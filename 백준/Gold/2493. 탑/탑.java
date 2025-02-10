import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int index, height;
	Point(int index, int height) {
		this.index = index;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> array = new ArrayList<>(N);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens())
			array.add(Integer.parseInt(st.nextToken()));
		
		Stack<Point> stack = new Stack<>();
		
		
		for (int i = 0; i < array.size(); i++) {
			
			int cur_num = array.get(i);
			
			while(!stack.isEmpty() && cur_num > stack.peek().height) 
				stack.pop();
			
			if(stack.isEmpty())
				array.set(i, 0);
			else
				array.set(i, stack.peek().index);
			
			stack.add(new Point(i+1 ,cur_num));
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int num : array)
			sb.append(num + " ");
		
		bw.write(sb.toString());
		bw.flush();
	}
}