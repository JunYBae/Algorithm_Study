import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x, y, num;
	Point(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Main {

	static int N, r, c, answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;
		
		int temp = (int)Math.pow(2, N);
		
		binary_search(temp, new Point(0, 0, 0));
	}
	
	public static void binary_search(int size, Point top) {

		while(size != 0) {
			
			if (r < (top.x + size / 2) && c < (top.y + size / 2)) { }
				
			else if (r < (top.x + size / 2) && c >= (top.y + size / 2)) { 
				top.y = top.y + size / 2;
				top.num += (int)Math.pow((size / 2), 2);
			}
			
			
			else if (r >= (top.x + size / 2) && c < (top.y + size / 2))  {
				top.x = top.x + size / 2;
				top.num += (int)Math.pow((size / 2), 2) * 2;
			}
						
			else {
				top.x = top.x + size / 2;
				top.y = top.y + size / 2;
				top.num += (int)Math.pow((size / 2), 2) * 3;
			}		
			
			size /= 2;	
		}
		System.out.println(top.num);
	}
}

