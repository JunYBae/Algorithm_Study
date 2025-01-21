import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	static HashMap<Character, Character> map = new HashMap<>();
	
	public static void main(String[] args) {
		//코드를 작성해주세요. 
		Scanner sc = new Scanner(System.in);
		
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		
		for (int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			sc.nextLine();
			String st = sc.nextLine();
			
			Stack<Character> stack = new Stack<>();
			boolean success = true;
			
			for (int i = 0; i < size; i++) 
			{
				char ch = st.charAt(i);

				if (!map.containsKey(ch))
					stack.add(ch);
				
				else {
					if (!stack.isEmpty() && stack.pop() != map.get(ch)) {
						success = false;
						break;
					}
				}		

			}
			
			if (success && stack.isEmpty())
				System.out.println("#" + test_case + " " + 1);
			else
				System.out.println("#" + test_case + " " + 0);
			
			
		}
	}
}