import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static TreeSet<String> map = new TreeSet<>(Comparator.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String line[] = br.readLine().split(" ");
			
			if (line[1].equals("enter"))
				map.add(line[0]);
			else
				map.remove(line[0]);
		}
		
			
		for (String st : map) {
			bw.write(st+"\n");
		}
		bw.flush();
	}
}