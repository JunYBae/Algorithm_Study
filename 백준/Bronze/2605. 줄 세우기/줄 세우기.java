
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int cur_num = 0; cur_num < T; cur_num++)
		{
			int num = sc.nextInt();			
			list.add(cur_num - num, cur_num+1);
		}
		
		for (int number : list)
			System.out.print(number + " ");
	}
	
}
