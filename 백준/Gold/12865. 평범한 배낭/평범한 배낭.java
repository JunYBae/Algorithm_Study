import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.util.Elements;

class Element {
	int weight, value;
	
	Element(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

public class Main {
	
	static int N, K, weights[];
	static Element element_list[];
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물건의 개수
		K = Integer.parseInt(st.nextToken()); // 버틸수 있는 최대 무게 
		element_list = new Element[N];
		weights = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			element_list[i] = new Element(weight, value);
		}
		
		for (int i = 0; i < N; i++) {		
			Element element = element_list[i];
			
			for (int index = K; index >= element.weight; index--) {
				if (weights[index - element.weight] + element.value > weights[index]) {
					weights[index] = weights[index - element.weight] + element.value;
				}
			}
		}
		
		
		System.out.println(weights[K]);
	}

}


