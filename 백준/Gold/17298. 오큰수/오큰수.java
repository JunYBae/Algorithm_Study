import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int array[], answer[];
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		array = new int[N];
		answer = new int[N];
		
		for (int i = 0; i < N; i++) 
			array[i] = Integer.parseInt(st.nextToken());
		
		
		for (int index = N-1; index >= 0; index--) {
			
			int cur_num = array[index]; // 현재 번호
			
			// 비어있지 않으면서, 현재 번호가 더 크면
			while(!stack.isEmpty() && !(cur_num < stack.peek()) ) {
				stack.pop();
			}
			
			if (stack.isEmpty())
				answer[index] = -1;
			else
				answer[index] = stack.peek();
			
			stack.add(cur_num);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.length; i++)
			sb.append(answer[i] + " ");
		
		System.out.println(sb.toString());
	}
}
