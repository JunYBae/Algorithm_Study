import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int sizer = Integer.parseInt(br.readLine());
		int now = 1;
		
		int Stack[] = new int[100000];
		int cnt = 0;
		
		while(now <= sizer) {
			
			st = new StringTokenizer(br.readLine());
			
			String menu = st.nextToken();
			
			switch(menu) {
			case "push":
				int temp = Integer.parseInt(st.nextToken());
				Stack[++cnt] = temp;	
				break;
				
			case "pop":
				System.out.println((cnt == 0) ? -1 : Stack[cnt--]);
				break;
				
			case "size":
				System.out.println(cnt);
				break;
				
			case "empty":
				System.out.println((cnt == 0) ? 1 : 0);
				break;
				
			case "top":
				System.out.println((cnt == 0) ? -1 : Stack[cnt]);
				break;
			}
			
			now++;
		}
	}
}