public class MineSweeperStringsTest {
    public static void main(String[] args) {
        MineSweeperStrings mss = new MineSweeperStrings();
        assert mss.generate(1, 0).equals("*") : "Test 1 failed";
        assert mss.generate(1, 1).equals("0") : "Test 2 failed";
        assert mss.generate(1, 47).equals("") : "Test 3 failed";
        assert mss.generate(7, 71).equals("0001*2*") : "Test 4 failed";
        assert mss.generate(14, 9876543210987654L).equals("") : "Test 5 failed";
        assert mss.generate(47, 47).equals("*****************************************11*2*1") : "Test 6 failed";
        assert mss.generate(3, 0).equals("***") : "Test 7 failed";
        assert mss.generate(3, 1).equals("**1") : "Test 8 failed";
        assert mss.generate(3, 2).equals("*10") : "Test 9 failed";
        assert mss.generate(3, 3).equals("*2*") : "Test 10 failed";
        assert mss.generate(3, 4).equals("000") : "Test 11 failed";
        assert mss.generate(3, 5).equals("01*") : "Test 12 failed";
        assert mss.generate(3, 6).equals("1**") : "Test 13 failed";
        assert mss.generate(3, 7).equals("1*1") : "Test 14 failed";
        assert mss.generate(3, 8).equals("") : "Test 15 failed";
        assert mss.generate(3, 124125).equals("") : "Test 16 failed";
        assert mss.generate(3, 1000000000000000000L).equals("") : "Test 17 failed";
        assert mss.generate(60, 1000000000000000000L).equals("1**2*2******11*11*11**2***2*11***2*11*101*******************") : "Test 18 failed";
        assert mss.generate(60, 100000000000000000L).equals("***11*1001*11****11**2*2*****11*2**2****11******************") : "Test 19 failed";
        assert mss.generate(60, 10000000000000000L).equals("******1001*2*****2**2*2***101*11*2*2*100001*****************") : "Test 20 failed";
        assert mss.generate(60, 100000000000000L).equals("*************11*11**2*2***2****100001*2*11***100000000000000") : "Test 21 failed";
        assert mss.generate(60, 100000000000L).equals("***********************11*2**101*****2*11*11*2**100000000000") : "Test 22 failed";
        assert mss.generate(60, 100000000L).equals("*********************************11*2*2**11*2*10001*********") : "Test 23 failed";
        assert mss.generate(60, 100000L).equals("*******************************************2*****2**11******") : "Test 24 failed";
        assert mss.generate(60, 100L).equals("*****************************************************2***100") : "Test 25 failed";
        assert mss.generate(60, 0).equals("************************************************************") : "Test 26 failed";
        assert mss.generate(47, 3295230580238502L).equals("") : "Test 27 failed";
        assert mss.generate(47, 3205230582085855L).equals("") : "Test 28 failed";
        assert mss.generate(47, 2345).equals("***********************************101***11***1") : "Test 29 failed";
        assert mss.generate(47, 240359305305380658L).equals("") : "Test 30 failed";
        assert mss.generate(1, 3).equals("") : "Test 31 failed";
        assert mss.generate(59, 1000000000L).equals("*****************************2*11*2***2**11*101**1000000000") : "Test 32 failed";
        System.out.println("All tests passed!");
    }
}
