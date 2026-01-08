// https://archive.topcoder.com/ProblemStatement/pm/17816
// Solution: DP over signed sums to reach the goal difference, then reconstruct flips.

import java.util.*;

public class FlippingCoinSum {
    public int[] flip(int[] faceUp, int[] faceDown, int goal){
        int nUp = faceUp.length;
        int nDn = faceDown.length;
        int n = nUp+nDn;

        int[] val = new int[n];
        int idx = 0;
        for(int v: faceDown) val[idx++] = v;
        for(int v: faceUp) val[idx++] = -v;
        int startSum = 0;
        for(int v: faceUp) startSum += v;

        int diff = goal-startSum;
        int tot = 0;
        for(int v: val) tot += Math.abs(v);
        if(Math.abs(diff) > tot){
            return new int[]{-123456789};
        }
        int shift = tot;
        int size = 2*tot+1;
        final int INF = 1 << 20;
        int[] best = new int[size];
        int[] prev = new int[size];
        int[] who = new int[size];
        Arrays.fill(best,INF);
        Arrays.fill(prev,-1);
        Arrays.fill(who,-1);

        best[shift] = 0;
        for(int i=0; i<n; i++){
            int w = val[i];
            int[] prevBest = best.clone();
            for(int s=0; s<size; s++){
                if(prevBest[s] == INF) continue;
                int ns = s + w;
                if(ns < 0 || ns>= size) continue;
                if(prevBest[s] + 1 < best[ns]){
                    best[ns] = prevBest[s] + 1;
                    prev[ns] = s;
                    who[ns] = i;
                }
            }
        }
        int target = diff + shift;
        if(best[target] == INF){
            return new int[]{-123456789};
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int cur = target;
        while(cur != shift){
            int coinIdx = who[cur];
            answer.add(val[coinIdx]);
            cur = prev[cur];
        }
        int[] res = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) res[i] = answer.get(i);
        return res;
     }

}
