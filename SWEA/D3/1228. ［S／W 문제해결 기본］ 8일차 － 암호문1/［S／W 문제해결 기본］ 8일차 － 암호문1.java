import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	
	static LinkedList<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= 10; test_case++)
		{
			list = new LinkedList<>();
			
			int T = Integer.parseInt(br.readLine());
			String st[] = br.readLine().split(" ");
			
			for (int i = 0; i < T; i++)
				list.add(Integer.parseInt(st[i]));
			
			T = Integer.parseInt(br.readLine());
			st = br.readLine().trim().split("I");
			
			for (int i = 1; i < st.length; i++) {
				
				String temp[] = st[i].trim().split(" ");
				
				int index = Integer.parseInt(temp[0]);
				int count = Integer.parseInt(temp[1]);
				
				for (int cur = 1; cur <= count; cur++)
				{	
					list.add(index, Integer.parseInt(temp[cur+1]));
					index++;
				}
				
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++)
				System.out.print(list.get(i) +" ");
			System.out.println();
		}
	}
}


