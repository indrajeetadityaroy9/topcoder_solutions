// https://archive.topcoder.com/ProblemStatement/pm/18235
// Solution: iterate range and sum max(x, reverse(x)).

public class NumReverseEasy {
    public long getsum(int A, int B){
        long ans = 0;
        for(int x=A; x<=B; x++){
            int rev = reverse(x);
            ans += Math.max(x,rev);
        }
        return ans;
    }
    private int reverse(int x){
        int rev = 0;
        while(x>0){
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev;
    }
    
}
