import java.util.HashMap;
import java.util.Scanner;

class Main {

	static String line, line_array[] = new String[3];
	static HashMap<String, Double> hashmap = new HashMap<>();
	
	
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);
 		double count = 0;
 		double score = 0;
 		
 		set_hashmap();
 		
 		while (sc.hasNextLine()) {
 			line = sc.nextLine();
 			line_array = line.split(" ");
 			
 			if(line_array[0].equals(""))
 				break;
 			
 			else if (line_array[2].equals("P") || line_array[2].equals("N"))
 				continue;
 			
 			count += Double.parseDouble(line_array[1]);		
 			score += hashmap.get(line_array[2]) * Double.parseDouble(line_array[1]);
 			
		
 		}
 		
 		System.out.print(score/count);
 		
 	}
 	
		
		
	public static void set_hashmap() {
		hashmap.put("A+", 4.5);
		hashmap.put("A0", 4.0);
		hashmap.put("B+", 3.5);
		hashmap.put("B0", 3.0);
		hashmap.put("C+", 2.5);
		hashmap.put("C0", 2.0);
		hashmap.put("D+", 1.5);
		hashmap.put("D0", 1.0);
		hashmap.put("F", 0.0);
	}
}






