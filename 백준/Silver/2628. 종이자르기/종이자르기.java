import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	
	static ArrayList<Integer> width_cut = new ArrayList<>(); // 가로
	static ArrayList<Integer> length_cut = new ArrayList<>();  // 세로
	
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int length = sc.nextInt();
		int T = sc.nextInt();
		
		if (T == 0) {
			System.err.println(width*length);
			return;
		}
		
		for (int i = 0; i < T; i++)
		{
			int where = sc.nextInt();
			int number = sc.nextInt();
			
			if (where == 0)
				width_cut.add(number);
			
			else 
				length_cut.add(number);
		}
		
		Collections.sort(width_cut);
		Collections.sort(length_cut);
		
		int last_cut_width = 0;
		int last_cut_length = 0;
		int max_cm_2 = 0;
		
		for (int cur_width : width_cut)
		{
			int set_width = (cur_width - last_cut_width);
			int set_length = 0;
			last_cut_length = 0;
			
			for (int cur_length : length_cut)
			{				
				set_length = (cur_length - last_cut_length);
				
				if (max_cm_2 < set_width * set_length)
					max_cm_2 = set_width * set_length;
				
				last_cut_length = cur_length;
				//System.out.println(set_width * set_length);
				//System.out.println(set_width + ". " + set_length);
			}
			
			set_length = width - last_cut_length;
			
			if (max_cm_2 < set_width * set_length) 
				max_cm_2 = set_width * set_length;
			//System.out.println(set_width * set_length);
			//System.out.println(set_width + ". " + set_length);		
			last_cut_width = cur_width;
		}
		
		last_cut_length = 0;
		
		for (int cur_length : length_cut)
		{
			int set_width = (length - last_cut_width);
			int set_length = (cur_length - last_cut_length);
			if (max_cm_2 < set_width * set_length)
				max_cm_2 = set_width * set_length;
			//System.out.println(set_width + ". " + set_length);
			last_cut_length = cur_length;
		}
		
		if (max_cm_2 < (length - last_cut_width) * (width - last_cut_length))
			max_cm_2 =  (length - last_cut_width) * (width - last_cut_length);
		
		System.out.println(max_cm_2);
	}

}