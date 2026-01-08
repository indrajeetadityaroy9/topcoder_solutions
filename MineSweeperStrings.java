// https://archive.topcoder.com/ProblemStatement/pm/18236
// Solution: DP counts valid strings with adjacency constraints; then selects X-th lexicographic string.

public class MineSweeperStrings {
    private static final int DOT  = 0;    
    private static final int STAR = 1;    
    private static final int ZERO = 2;   
    private static final int ONE  = 3;    
    private static final int TWO  = 4;    

    private static final long LIMIT = 1_000_000_000_000_000_005L;

    private int len;             
    private long[][][] dp;      

    private long ways(int pos, int prev, int prev2) {
        if (pos == len) { 
            if (prev >= ZERO) {
                int required = prev - ZERO;    
                int left     = (prev2 == STAR) ? 1 : 0;
                return (required == left) ? 1 : 0;
            }
            return 1;
        }

        if (dp[pos][prev][prev2] != -1) return dp[pos][prev][prev2];

        long res = 0;
        for (int c = STAR; c <= TWO; ++c) { 
            if (prev >= ZERO) {
                int required = prev - ZERO;
                int left     = (prev2 == STAR) ? 1 : 0;
                int right    = (c     == STAR) ? 1 : 0;
                if (required != left + right) continue;
            }
            res += ways(pos + 1, c, prev);
            if (res > LIMIT) res = LIMIT;
        }
        return dp[pos][prev][prev2] = res;
    }

    public String generate(int N, long X) {
        len = N;
        dp  = new long[N + 1][5][5];
        for (int i = 0; i <= N; ++i)
            for (int j = 0; j < 5; ++j)
                java.util.Arrays.fill(dp[i][j], -1);

        long total = ways(0, DOT, DOT);
        if (X >= total) return "";

        StringBuilder sb  = new StringBuilder();
        int prev2 = DOT, prev = DOT; 

        for (int pos = 0; pos < N; ++pos) {
            boolean chosen = false;
            for (int c = STAR; c <= TWO; ++c) { 
                if (prev >= ZERO) {
                    int required = prev - ZERO;
                    int left     = (prev2 == STAR) ? 1 : 0;
                    int right    = (c     == STAR) ? 1 : 0;
                    if (required != left + right) continue;
                }

                long cnt = ways(pos + 1, c, prev);
                if (X < cnt) {
                    sb.append(codeToChar(c));
                    prev2  = prev;
                    prev   = c;
                    chosen = true;
                    break;
                }
                X -= cnt;
            }
            if (!chosen) return ""; 
        }
        return (X == 0) ? sb.toString() : "";
    }

    private static char codeToChar(int code) {
        switch (code) {
            case STAR: return '*';
            case ZERO: return '0';
            case ONE : return '1';
            case TWO : return '2';
        }
        throw new AssertionError();
    }
    
}
