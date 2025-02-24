import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, number[], operator[], max, min;
	static char cal_oper[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4];
		cal_oper = new char[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) 
			number[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		
		Tracking(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void Tracking(int length) {
		
		if (length == N-1) {
			
			int temp = calculate();
			
			if (temp > max)
				max = temp;
			
			if (temp < min)
				min = temp;
			
			return;
		}
		
		
		for (int index = 0; index < operator.length; index++) {
			
			if(operator[index] > 0) {
				
				operator[index]--;
				
				switch(index) {
				case 0:
					cal_oper[length] = '+';
					break;
					
				case 1:
					cal_oper[length] = '-';
					break;
					
				case 2:
					cal_oper[length] = '*';
					break;
					
				case 3:
					cal_oper[length] = '/';
					break;
				}
				
				Tracking(length+1);
				
				operator[index]++;
				
			}
		}
	}
	
	public static int calculate() {
		
		int sum = 0;
		
		sum = number[0];
		
		for (int index = 0; index < cal_oper.length; index++) {
			
			int cur_num = number[index+1];
			
			switch(cal_oper[index]) {
			case '+':
				sum += cur_num;
				break;
				
			case '-':
				sum -= cur_num;
				break;
				
			case '*':
				sum *= cur_num;
				break;
				
			case '/':
				sum /= cur_num;
				break;
			}
			
		}
		
		return sum;
		
	}
	 
}

