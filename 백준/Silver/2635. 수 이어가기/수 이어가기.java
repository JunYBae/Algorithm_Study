
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int max_size = 0;
	static ArrayList<int[]> set = new ArrayList<>(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init_number = sc.nextInt();
		
		for (int cur_number = init_number; cur_number > 0; cur_number--) 
		{
			//System.out.println("cur_number : " + cur_number);
			ArrayList<Integer> save_number = new ArrayList<>();
			number_concat(save_number, init_number, cur_number);
			//System.out.println();
		}
		
		//System.out.println(set.size());
		
		
		for (int i = 0; i < set.size(); i++) {
			int get[] = set.get(i);
			
			if (get.length == max_size) {
				System.out.println(max_size);
				for (int j = 0; j < get.length; j++)
					System.out.print(get[j] + " ");
				return;
			}
			
		}
		
	}
	
	public static void number_concat(ArrayList<Integer> save_number, int first_number, int second_number) {
					
			//System.out.println("first number : " + first_number + ", second number : " + second_number);
			
			save_number.add(first_number);	
			int temp = first_number;
			first_number = second_number;
			second_number = temp - second_number;
			
			if (second_number < 0) {
				
				save_number.add(first_number);	
				
				if (max_size <= save_number.size()) {
					max_size = save_number.size();
					int array[] = new int[max_size];
					
					for (int i = 0; i < save_number.size(); i++) 
						array[i] = save_number.get(i);
					
					set.add(array);
					return;
				}
				
				return;		
			}
						
			number_concat(save_number, first_number, second_number);
					
	}
	
}

