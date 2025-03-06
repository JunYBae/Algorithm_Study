import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, numbers[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visit = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(numbers);
		Combination(0, 0, 0, new ArrayList<Integer>());

		int answer = 0;
		for (int i = 0; i < N; i++)
			if (visit[i])
				answer++;

		System.out.println(answer);
	}

	public static void Combination(int vertex, int length, int sum, ArrayList<Integer> index_list) {

		if (length == 2) {
			binary_search(vertex, sum, index_list);
			return;
		}

		for (int i = vertex; i < N; i++) {
			index_list.add(i);
			Combination(i + 1, length + 1, sum + numbers[i], index_list);
			index_list.remove(index_list.size() - 1);
		}
	}

	public static void binary_search(int vertex, int sum, ArrayList<Integer> index_list) {

		int left = 0;
		int right = N - 1;
		int min_start = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (numbers[mid] == sum) {
				if (!index_list.contains(mid))
					min_start = mid;
				right = mid - 1;
			}

			else if (numbers[mid] < sum)
				left = mid + 1;

			else if (numbers[mid] > sum)
				right = mid - 1;

		}
		
		if (min_start != -1) {
			for (int index = min_start; index < N && numbers[index] == sum; index++)
				visit[index] = true;
		}
	}
}
