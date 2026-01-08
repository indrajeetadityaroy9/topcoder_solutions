# TopCoder Solutions

https://archive.topcoder.com/ProblemArchive

| Problem | File | Language | Entry Point | Summary |
| --- | --- | --- | --- | --- |
| CollectBoxes | CollectBoxes.cpp | C++ | `CollectBoxes::collect(int N, vector<int> Bprefix, int seed, int blo, int bhi)` | Sorts positions, uses prefix sums and precomputed minima to minimize total travel cost. |
| FlippingCoinSum | FlippingCoinSum.java | Java | `flip(int[] faceUp, int[] faceDown, int goal)` | DP over signed sums to reach target difference and reconstruct flips. |
| MineSweeperStrings | MineSweeperStrings.java | Java | `generate(int N, long X)` | DP counts valid strings with adjacency constraints, then lexicographically selects the X-th string. |
| NoteTakers | NoteTakers.java | Java | `solve(int N, int[] X, int[] Y, int[] D, int[] B, int[] T1, int[] T2)` | Floyd-Warshall + bipartite matching to build minimum path cover of feasible transitions. |
| NumReverseEasy | NumReverseEasy.java | Java | `getsum(int A, int B)` | Sums `max(x, reverse(x))` across a range. |
| ReversalSorting | ReversalSorting.java | Java | `solve(int[] P)` | Greedy breakpoint reduction with reversals; outputs reversal indices. |
| Split | split.cpp | C++ | `split(vector<int> skill, int K)` | Meet-in-the-middle to optimize weighted partition cost. |
