
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// 입력		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		int store_number = Integer.parseInt(br.readLine());
		int array[][] = new int[store_number][2];
		
		
		for (int i = 0; i < store_number; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int guard[][] = new int[][] {{Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())}};
					
		
		long min_value = 0;
		
		
		// 1 : 북, 2 : 남, 3 : 서, 4: 동
		for (int count = 0; count < store_number; count++)
		{
			switch(guard[0][0]) {
			case 1:
				if (array[count][0] == 1)
					min_value += Math.abs(guard[0][1] - array[count][1]);
				else if (array[count][0] == 2)
					min_value += Math.min(guard[0][1]+length+array[count][1], width-guard[0][1]+length+width-array[count][1]);
				else if (array[count][0] == 3)
					min_value += guard[0][1] + array[count][1];
				else if (array[count][0] == 4)
					min_value += width - guard[0][1] + array[count][1];
				break;
				
			case 2:
				if (array[count][0] == 1)
					min_value += Math.min(guard[0][1]+length+array[count][1], width-guard[0][1]+length+width-array[count][1]);
				else if (array[count][0] == 2)
					min_value += Math.abs(guard[0][1] - array[count][1]);
				else if (array[count][0] == 3)
					min_value += guard[0][1] + length - array[count][1];
				else if (array[count][0] == 4)
					min_value += width - guard[0][1] + length - array[count][1];
				break;
				
				
			case 3:
				if (array[count][0] == 1)
					min_value += guard[0][1] + array[count][1];
				else if (array[count][0] == 2)
					min_value += length - guard[0][1] + array[count][1];
				else if (array[count][0] == 3)
					min_value += Math.abs(guard[0][1] - array[count][1]);
				else if (array[count][0] == 4)
					min_value += Math.min(guard[0][1]+width+array[count][1], length-guard[0][1]+width+length-array[count][1]);
				break;
				
			case 4:
				if (array[count][0] == 1)
					min_value += guard[0][1] + width - array[count][1];
				else if (array[count][0] == 2)
					min_value += length - guard[0][1] + width - array[count][1];
				else if (array[count][0] == 3)
					min_value += Math.min(guard[0][1]+width+array[count][1], length-guard[0][1]+width+length-array[count][1]);
				else if (array[count][0] == 4)
					min_value += Math.abs(guard[0][1] - array[count][1]);
				break;
			}
			
		}
		
		bw.write(min_value+"\n");
		bw.flush();
		
	}
}

 