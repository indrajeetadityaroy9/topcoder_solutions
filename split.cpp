// https://archive.topcoder.com/ProblemStatement/pm/18025
// Solution: meet-in-the-middle with ternary choices to maximize score.

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
void dfs(int idx, const vector<int> &a, long long sInv, long long d, vector<pair<long long, long long> >&out){
    if(idx == (int)a.size()){
        out.emplace_back(d,sInv);
        return;
    }
    dfs(idx+1,a,sInv,d,out);
    dfs(idx+1,a,sInv+a[idx],d+a[idx],out);
    dfs(idx+1,a,sInv+a[idx],d-a[idx],out);
}
long long split(vector<int>skill, int K){
    const int n = skill.size();
    int mid = n/2;
    vector<int>left(skill.begin(), skill.begin()+mid);
    vector<int>right(skill.begin()+mid,skill.end());
    vector<pair<long long, long long> > L,R;
    dfs(0,left,0,0,L);
    dfs(0,right,0,0,R);
    sort(R.begin(),R.end());
    vector<pair<long long,long long> >Runiq;
    for(auto &p: R){
        if(Runiq.empty() || Runiq.back().first != p.first){
            Runiq.push_back(p);
        }else{
            Runiq.back().second = max(Runiq.back().second,p.second);
        }
    }
    const int m = (int) Runiq.size();
    vector<long long> arrD(m), arrS(m);
    for(int i=0; i<m; i++){
        arrD[i] = Runiq[i].first;
        arrS[i] = Runiq[i].second;
    }
    vector<long long> sufPlus(m),preMinus(m);
    for(int i=m-1; i>=0;i--){
        long long val = arrS[i] - (long long)K * arrD[i];
        sufPlus[i] = (i==m-1) ? val : max(val,sufPlus[i+1]);
    }
    for(int i=0; i<m; i++){
        long long val = arrS[i] + (long long)K * arrD[i];
        preMinus[i] = (i==0) ? val : max(val,preMinus[i-1]);
    }
    long long bestV = LLONG_MIN/4;
    for(auto &p: L){
        long long d1 = p.first;
        long long s1 = p.second;
        long long t = -d1;
        int idx = lower_bound(arrD.begin(), arrD.end(),t) - arrD.begin();
        if(idx < m){
            long long candidate = s1+ (sufPlus[idx]-(long long)K * d1);
            if(candidate > bestV) bestV = candidate;
        }
        if(idx > 0){
            long long candidate = s1+ (preMinus[idx-1]+(long long)K*d1);
            if(candidate > bestV) bestV = candidate;
        }
    }
    long long tot = 0;
    for(int v: skill) tot +=v;
    return (long long)(tot - bestV);
}
