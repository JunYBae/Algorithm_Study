import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Main {
	static Stack<Character> stack = new Stack<>();
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int count = 0;
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			String st = sc.next();
			stack.clear();
			
			for (int i = 0; i < st.length(); i++) {
				char temp = st.charAt(i);
				
				if (!stack.isEmpty()) {
					if(stack.peek() == temp) {
						stack.pop();
						continue;
					}
				}			
				stack.push(temp);			
			}
			
			if (stack.isEmpty())
				count++;
		}
		
		System.out.println(count);
		
	}
}