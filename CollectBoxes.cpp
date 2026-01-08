// https://archive.topcoder.com/ProblemStatement/pm/18172
// Solution: sort positions, use prefix sums and precomputed minima to minimize cost.

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

class CollectBoxes {
public:
    static inline long long plusVal(long long x) {
        return (x >= 0) ? 2LL * x : 0LL;
    }
    static inline long long minusVal(long long x) {
        return (x >= 0) ? 0LL : -2LL * x;
    }

    long long collect(int N, vector<int> Bprefix, int seed, int blo, int bhi) {
        vector<long long> B(N);
        int pref = (int)Bprefix.size();
        for (int i = 0; i < pref; ++i)
            B[i] = Bprefix[i];

        const long long MOD    = (1LL << 31) - 1;
        long long       state  = seed;
        long long       spread = 1LL * bhi - blo + 1;
        for (int i = pref; i < N; ++i) {
            state    = (state * 1103515245LL + 12345) & MOD;
            B[i]     = blo + (state % spread);
        }

        sort(B.begin(), B.end());

        vector<long long> prefSum(N);
        prefSum[0] = B[0];
        for (int i = 1; i < N; ++i)
            prefSum[i] = prefSum[i - 1] + B[i];
        long long totalSum = prefSum.back();

        vector<long long> prefMin(N);
        vector<long long> suffMin(N);

        prefMin[0] = plusVal(B[0]);
        for (int i = 1; i < N; ++i)
            prefMin[i] = std::min(prefMin[i - 1], plusVal(B[i]));

        suffMin[N - 1] = minusVal(B[N - 1]);
        for (int i = N - 2; i >= 0; --i)
            suffMin[i] = std::min(suffMin[i + 1], minusVal(B[i]));

        long long answer = LLONG_MAX;
        for (int i = 0; i < N; ++i) {
            long long F         = B[i];
            long long cntLeft   = i + 1;
            long long sumLeft   = prefSum[i];
            long long cntRight  = N - cntLeft;
            long long sumRight  = totalSum - sumLeft;

            long long S = F * cntLeft - sumLeft + sumRight - F * cntRight;

            if (S == 0) {
                return 0LL;
            }

            long long A  = suffMin[i];
            long long Bv = prefMin[i];

            long long mF = std::min(F + A, Bv - F);

            long long T = 2LL * S + mF;
            if (T < answer) answer = T;
        }
        return answer;
    }
};
