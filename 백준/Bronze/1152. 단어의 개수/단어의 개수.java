import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		String test = s.nextLine();
		int count = 1;
		
		if(test.charAt(0) == ' ')
			count--;
		if(test.charAt(test.length()-1) == ' ')
			count--;
			
		for(int i = 0; i < test.length(); i++) {
			if(test.charAt(i) == ' ')
				count++;
		}
		
		if(test.length() != 0)
			System.out.println(count);
		else
			System.out.println(0);
		
		s.close();
	}
}
