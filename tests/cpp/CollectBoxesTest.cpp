#include <cassert>
#include <iostream>
#include <vector>

#include "../../CollectBoxes.cpp"

int main() {
    CollectBoxes cb;

    std::vector<int> v1;
    v1.push_back(11); v1.push_back(10);
    assert(cb.collect(2, v1, 0, 0, 0) == 11);

    std::vector<int> v2;
    v2.push_back(10); v2.push_back(10); v2.push_back(11); v2.push_back(10); v2.push_back(10);
    assert(cb.collect(5, v2, 0, 0, 0) == 12);

    std::vector<int> v3;
    v3.push_back(-10); v3.push_back(-11);
    assert(cb.collect(2, v3, 0, 0, 0) == 11);

    std::vector<int> v4;
    v4.push_back(-47); v4.push_back(47);
    assert(cb.collect(2, v4, 0, 0, 0) == 141);

    std::vector<int> v5;
    v5.push_back(10); v5.push_back(20); v5.push_back(30);
    assert(cb.collect(9, v5, 47, -20, 100) == 322);

    std::vector<int> v6;
    v6.push_back(42);
    assert(cb.collect(1, v6, 0, 0, 0) == 0);

    std::vector<int> v7;
    v7.push_back(47); v7.push_back(47);
    assert(cb.collect(2, v7, 3, 3, 3) == 0);

    std::vector<int> v8;
    v8.push_back(-5); v8.push_back(-5); v8.push_back(-5);
    assert(cb.collect(3, v8, 56, 66, 77) == 0);

    std::vector<int> v9;
    v9.push_back(1000000000); v9.push_back(-1000000000); v9.push_back(1000000000);
    assert(cb.collect(3, v9, 47, 47, 47) == 3000000000LL);

    std::vector<int> empty;
    assert(cb.collect(500000, empty, 47, -1000000000, 1000000000) == 526657236972880LL);
    assert(cb.collect(499999, empty, 43, -1000000000, 1000000000) == 526120454326314LL);

    std::vector<int> v10;
    v10.push_back(-244415920);
    assert(cb.collect(1, v10, 268543586, -76182073, 188933013) == 0);

    std::vector<int> v11;
    v11.push_back(225763432); v11.push_back(-262404342);
    assert(cb.collect(2, v11, 1105644294, -169875016, 100465896) == 713931206LL);

    std::vector<int> v12;
    v12.push_back(100); v12.push_back(100);
    assert(cb.collect(2, v12, 0, 0, 0) == 0);

    std::vector<int> v13;
    v13.push_back(1); v13.push_back(1);
    assert(cb.collect(2, v13, 1, 1, 1) == 0);

    std::vector<int> v14;
    v14.push_back(1);
    assert(cb.collect(50000, v14, 11465, 0, 10000) == 250263956LL);

    std::vector<int> v15;
    v15.push_back(4); v15.push_back(4);
    assert(cb.collect(2, v15, 1, 10, 20) == 0);

    std::vector<int> v16;
    v16.push_back(-5); v16.push_back(10);
    assert(cb.collect(1000, v16, 47, -20, -10) == 5453LL);

    std::cout << "All tests passed!" << std::endl;
    return 0;
}
