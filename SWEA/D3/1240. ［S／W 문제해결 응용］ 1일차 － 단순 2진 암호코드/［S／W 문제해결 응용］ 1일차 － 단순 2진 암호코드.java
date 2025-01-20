import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char array[][];
	static String number[] = {"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"};
	static int answer = 0;
	
	static ArrayDeque<Integer> list = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			String line[] = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			boolean searching = true;
			
			array = new char[N][M];
			int odd = 0;
			int add = 0;
			answer = 0;
			
			
			for (int i = 0; i < N; i++)
			{
				String temp = br.readLine();
				for (int j = 0; j < M; j++)
				{
					array[i][j] = temp.charAt(j);
				}
			}
			
			for (int i = 0; i < N; i++)
			{
				if(!searching)
					break;
				
				for (int j = M-1; j >= 0; j--)
				{
					if(array[i][j] == '1')
					{
						number_check(i, j);
						j -= 6;
						searching = false;
					}
				}
			}
			
			int size = list.size();
			
			for (int i = 0; i < size; i++) {
				if (i % 2 == 0)
					odd += list.pollLast();
				else
					add += list.pollLast();
			}
				
			
			answer = odd * 3 + add;
			System.out.println("#" + test_case + " " + (answer % 10 == 0 ? add+odd : 0));
		}
	}
	
	public static void number_check(int i, int j) {
		
		int index = 6;
		String st = "";
		
		while (index >= 0) {
			st += array[i][j - index];
			index--;
		}
		
		
		for (int k = 0; k < 10; k++) 
			if (st.equals(number[k])) { 
				list.add(k);
				break;
			}
	}
}










