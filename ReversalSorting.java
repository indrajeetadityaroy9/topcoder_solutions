import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Solution: greedy breakpoint reduction by reversing subarrays.
public class ReversalSorting {
    private static int bp(int[] a){
        int n = a.length;
        int[] p = new int[n + 2];
        p[0] = -1;
        System.arraycopy(a, 0, p, 1, n);
        p[n + 1] = n;
    
        int b = 0;
        for(int i = 0; i < p.length - 1; i++){
            if(Math.abs(p[i] - p[i + 1]) != 1) b++;
        }
        return b;
    }
    private static void reverse(int[] a, int l, int r){
        for(int i=l,j=r-1; i<j; i++,j--){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    private static int[] toRanks(int[] a){
        int n = a.length;
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        Map<Integer, ArrayDeque<Integer>> pos = new HashMap<>();
        for(int i=0; i<n; i++){
            pos.computeIfAbsent(sorted[i], k -> new ArrayDeque<>()).add(i);
        }
        int[] ranks = new int[n];
        for(int i=0; i<n; i++){
            ranks[i] = pos.get(a[i]).removeFirst();
        }
        return ranks;
    }
    public int[] solve(int[] P){
        int n = P.length;
        List<Integer> ans = new ArrayList<>();
        int [] perm = toRanks(P);

        while(true){
            int curBp = bp(perm);
            if(curBp == 0) break;

            int bestGain = 0, bestL = -1, bestR = -1;

            for(int l=0; l<n; l++){
                for(int r=l+2;r<=n;r++){
                    reverse(perm, l, r);
                    int gain = curBp - bp(perm);
                    reverse(perm, l, r);
                    if(gain > bestGain){
                        bestGain = gain;
                        bestL = l;
                        bestR = r;
                        if(gain >= 2) break;
                    }
                }
                if(bestGain >= 2) break;
            }
            if(bestGain == 0){
                int i = 0;
                while(i < n && perm[i] == i) i++;
                int pos = i;
                for(int j = i + 1; j < n; j++) {
                    if (perm[j] == i) {
                        pos = j;
                        break;
                    }
                }
                bestL = i;
                bestR = pos + 1;
            }
            reverse(perm, bestL, bestR);
            ans.add(bestL);
            ans.add(bestR);
        }
        int[] ret = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }

}
