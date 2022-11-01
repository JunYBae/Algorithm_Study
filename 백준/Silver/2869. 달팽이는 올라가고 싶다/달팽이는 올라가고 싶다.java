import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int climb = Integer.parseInt(st.nextToken());
		int slide = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
	
		count = (size-climb) / (climb-slide);
		
		if((size-climb) % (climb-slide) != 0)
			count++;
	
		count++;		
		
		System.out.println(count);
	}
}
