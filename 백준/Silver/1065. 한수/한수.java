import java.util.Scanner;

class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		if (number < 100) {
			System.out.println(number);
			return;
		}
		
		int count = 99;
		
		for (int i = 100; i <= number; i++)
		{
			String st = Integer.toString(i);
			int tum = (st.charAt(0) - '0') - (st.charAt(1) - '0');
			boolean is_success = true;
			
			for (int index = 1; index < st.length() - 1; index++)
			{
				int check = (st.charAt(index) - '0') - (st.charAt(index+1) - '0');
				
				if(tum != check) {
					is_success = false;
					break;
				}
			}
			
			if (is_success)
				count++;
		}
		
		System.out.println(count);
			
	}
}