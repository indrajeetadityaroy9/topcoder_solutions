import java.util.*;

// Solution: all-pairs shortest paths + bipartite matching for minimum path cover.
public class NoteTakers{
    public int[] solve(int N, int[] X, int[] Y, int[] D, int[] B, int[]T1, int[]T2){
        int M = B.length;
        final long INF = (long)4e18;
        long[][] dist = new long[N][N];
        for(int i=0;i<N; i++){
            Arrays.fill(dist[i],INF);
        }
        for(int i=0; i<N; i++) dist[i][i] = 0;

        for(int i=0; i<X.length; i++){
            int u = X[i], v = Y[i];
            long w = D[i];
            if(w < dist[u][v]){
                dist[u][v] = dist[v][u] = w;
            }
        }
        for(int k =0; k<N; k++){
            for(int i=0; i<N; i++){
                if(dist[i][k] != INF){
                    for(int j=0; j<N; j++){
                        if(dist[k][j] != INF && dist[i][j] > dist[i][k]+dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        List<List<Integer>> adj = new ArrayList<>(M);
        for(int i=0; i<M; i++) adj.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                if(i != j){
                    long d = dist[B[i]][B[j]];
                    if(d != INF && (long)T2[i] + d <= (long)T1[j]){
                        adj.get(i).add(j);
                    }
                }
            }
        }
        int[] matchR = new int[M];
        Arrays.fill(matchR,-1);
        int matching = 0;
        for(int u=0; u<M; u++){
            boolean[] seen = new boolean[M];
            if(dfsAugment(u, adj, matchR, seen)) matching++;
        }
        int[] succ = new int[M];
        int[] pred = new int[M];
        Arrays.fill(succ,-1);
        Arrays.fill(pred,-1);
        for(int r=0; r<M; r++){
            int l = matchR[r];
            if(l != -1){
                succ[l] = r;
                pred[r] = l;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<M; i++){
            if(pred[i] == -1){
                int curr = i;
                while(curr != -1){
                    answer.add(curr);
                    curr = succ[curr];
                }
                // -1 separates chains in the path cover.
                answer.add(-1);
            }
        }
        int NoteTakers = M-matching;
        int[] res = new int[answer.size()];
        for(int i=0; i<res.length; i++) res[i] = answer.get(i);
        return res;
    }
    private boolean dfsAugment(int u, List<List<Integer>> adj, int[] matchR, boolean[] seen){
        for(int v: adj.get(u)){
            if(seen[v]) continue;
            seen[v] = true;
            if(matchR[v] == -1 || dfsAugment(matchR[v], adj, matchR, seen)){
                matchR[v] = u;
                return true;
            }
        }
        return false;
    }
}
