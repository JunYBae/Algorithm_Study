import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int x, y, cost;
    
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class Solution {
    
    private static int n;
    private static int[][] map;
    private static int[][] dist;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        for (int test = 1; test <= tc; test++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dist = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            dist[0][0] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));
            
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int x = cur.x;
                int y = cur.y;
                int cost = cur.cost;
                
                if (cost > dist[x][y])
                    continue;
                
                if (x == n - 1 && y == n - 1)
                    break;
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (isIn(nx, ny)) {
                        int nextCost = cost + map[nx][ny];
                        if (nextCost < dist[nx][ny]) {
                            dist[nx][ny] = nextCost;
                            pq.offer(new Node(nx, ny, nextCost));
                        }
                    }
                }
            }
            
            sb.append("#").append(test).append(" ").append(dist[n - 1][n - 1]).append("\n");
        }
        
        System.out.println(sb);
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
   
}
