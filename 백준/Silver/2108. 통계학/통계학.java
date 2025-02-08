import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class Main {
	
	static ArrayList<Integer> list = new ArrayList<>();
	static TreeMap<Integer, Integer> recent_list = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			sum += num;
			
			recent_list.put(num, recent_list.getOrDefault(num, 0) + 1);
		}
	
		Collections.sort(list);
		
		int max_size = 0;
		
		for (int value : recent_list.values()) {
			if (max_size < value)
				max_size = value;
		}
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>(recent_list.keySet());
		int count = 0;
		int index = 0;
		
		for (int number : set) {
			int value = recent_list.get(number);
			if (value == max_size) {
				index = number;
				//System.out.println("test"  + index);
				count++;
			}
			
			if (count == 2)		
				break;			
		}
		
		bw.write((int) Math.round(sum/N) + "\n");
		bw.write(list.get(N/2)+"\n");
		bw.write((index)+"\n");
		bw.write(Math.abs(list.get(0) - list.get(N-1))+"\n");
		bw.flush();
	}
}