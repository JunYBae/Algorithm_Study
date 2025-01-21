import java.util.Scanner;


class Solution { 
	
	public static void main(String[] args) {
		//코드를 작성해주세요. 
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		sc.nextLine(); // enter 날리기
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			String memory = sc.nextLine();
			int current_number = 0, count = 0; 
			
			for (int i = 0; i < memory.length(); i++)
			{
				
				if (memory.charAt(i) - '0' != current_number) {
					count += 1;
					current_number = (current_number + 1) % 2;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
			
		}
	}
}