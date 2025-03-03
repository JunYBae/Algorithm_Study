import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        boolean visit[] = new boolean[N+1];
        
        simulation(0, visit, sb);

        System.out.println(sb.toString());
    }
    
    public static void simulation(int length, boolean visit[], StringBuilder sb) {
    	
    	if (length == N) {
    		for (int num : answer)
    			sb.append(num).append(" ");
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		if (!visit[i]) {
    			visit[i] = true;
    			answer[length] = i;
    			simulation(length+1, visit, sb);
    			visit[i] = false;
    		}
    			
    	}
    	
    	
    }
} 	


