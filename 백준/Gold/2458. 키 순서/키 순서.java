import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[] check_map;
    static ArrayList<ArrayList<Integer>> forward_graph, reverse_graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        forward_graph = new ArrayList<>();
        reverse_graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
        	
            forward_graph.add(new ArrayList<>());
            reverse_graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
        	
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            forward_graph.get(start).add(end);
            reverse_graph.get(end).add(start);
        }

        check_map = new boolean[N + 1];

        // 모든 정점에 대해 탐색
        for (int i = 1; i <= N; i++) {
            Arrays.fill(check_map, false);
            
            check_connect(i, forward_graph);
            check_connect(i, reverse_graph);

            if (is_success()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void check_connect(int start, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        check_map[start] = true;

        while (!queue.isEmpty()) {
            int cur_node = queue.poll();

            for (int next_node : graph.get(cur_node)) {
                if (!check_map[next_node]) {  
                    check_map[next_node] = true;
                    queue.add(next_node);
                }
            }
        }
    }

    public static boolean is_success() {
        for (int i = 1; i <= N; i++) {
            if (!check_map[i])
                return false;
        }
        return true;
    }
}
