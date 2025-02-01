import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	
	static Stack<Integer> list;
	static Stack<Integer> big_number;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 숫자 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new Stack<>(); // 값 저장할 arraylist
		big_number = new Stack<>(); // 숫자가 큰 순서대로 담을 arraylist
		answer = new ArrayList<>(N); // 답을 저장할 arraylist
		
		for (int i = 0; i < N; i++) 
			list.add(Integer.parseInt(st.nextToken())); // 값 저장 (list)
		
		answer.add(-1); // 어차피 맨 뒤값은 -1 임
		big_number.add(list.pop()); // 맨뒤값 넣고 시작
		
		// 오큰수 계산
		while (!list.isEmpty())
		{
			int cur_number = list.pop(); // 값 하나 가져오기 뒤에서 부터
			
			while(!big_number.isEmpty())
			{			
				if (big_number.peek() > cur_number) { // 픽 했을때 더 클때
					answer.add(big_number.peek()); // 픽만 해서 빼기 (또 쓸수있음!)
					break;
				}
				
				big_number.pop(); // 이전의 값 계속 제거 / 왜? 이전값보다 현재값이 더 큼 / 그게 오큰수가 됨!
									// 이전 값은 필요 없어지기 때문!
			}
			
			if (big_number.isEmpty()) // 오큰수를 만족하는 숫자가 없을 때 
				answer.add(-1);	// -1 넣기
	
			big_number.add(cur_number);	
		
		}
		
		for (int index = answer.size() - 1; index >= 0; index--)
			bw.write(answer.get(index) + " ");
		
		bw.flush();
		
	}
	
}