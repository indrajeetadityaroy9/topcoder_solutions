import java.util.Arrays;

public class FlippingCoinSumTest {
    public static void main(String[] args) {
        FlippingCoinSum obj = new FlippingCoinSum();
        int[] res1 = obj.flip(new int[]{2, 2, 5}, new int[]{1, 10}, 9);
        assert Arrays.equals(res1, new int[]{});
        int[] res2 = obj.flip(new int[]{2, 2, 5}, new int[]{1, 10}, 14);
        assert Arrays.equals(res2, new int[]{-5, 10});
        int[] res3 = obj.flip(new int[]{2, 2, 5}, new int[]{2, 10}, 3);
        assert Arrays.equals(res3, new int[]{-123456789});
        int[] res4 = obj.flip(new int[]{2, 2, 5}, new int[]{100, 10}, 5);
        assert Arrays.equals(res4, new int[]{-2, -2});
        int[] res5 = obj.flip(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, 10);
        assert Arrays.equals(res5, new int[]{1, 1, 1});
        int[] res6 = obj.flip(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3}, new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
        assert Arrays.equals(res6, new int[]{-1, -1, -2, -2, -2, -3, -3, -3, -3});
        int[] res7 = obj.flip(new int[]{5, 5, 5, 5, 47, 100}, new int[]{42, 80, 174}, 147);
        assert Arrays.equals(res7, new int[]{-100, 80});
        int[] faceUp8 = new int[50];
        int[] faceDown8 = new int[50];
        Arrays.fill(faceUp8, 1000);
        Arrays.fill(faceDown8, 1000);
        int[] res8 = obj.flip(faceUp8, faceDown8, 100000);
        int[] expected8 = new int[50];
        Arrays.fill(expected8, 1000);
        assert Arrays.equals(res8, expected8);
        int[] faceUp9 = new int[50];
        int[] faceDown9 = new int[50];
        for (int i = 0; i < 50; i++) {
            faceUp9[i] = 951 + i;
            faceDown9[i] = 951 + i;
        }
        int[] res9 = obj.flip(faceUp9, faceDown9, 97550);
        int[] expected9 = new int[50];
        for (int i = 0; i < 50; i++) expected9[i] = 951 + i;
        assert Arrays.equals(res9, expected9);

        int[] t10 = new int[50];
        int[] t10b = new int[50];
        for (int i = 0; i < 50; i++) t10[i] = t10b[i] = 951 + i;
        int[] r10 = obj.flip(t10, t10b, 0);
        int[] e10 = new int[50];
        for (int i = 0; i < 50; i++) e10[i] = -(951 + i);
        assert Arrays.equals(r10, e10);
        int[] t11 = new int[50];
        int[] t11b = new int[50];
        for (int i = 0; i < 50; i++) t11[i] = t11b[i] = 951 + i;
        int[] r11 = obj.flip(t11, t11b, 12345);
        assert Arrays.equals(r11, new int[]{-123456789});
        int[] t12 = {8, 975, 982, 970, 997, 976, 987, 996, 990, 965, 969, 978, 971, 1, 1000, 980, 999, 995, 991, 973, 988, 993, 963, 256, 964, 968, 974, 961, 981, 992, 998, 4, 64, 983, 989, 967, 2, 962, 32, 979, 977, 512, 16, 984, 966, 986, 994, 128, 985, 972};
        int[] t12b = t12.clone();
        int[] r12 = obj.flip(t12, t12b, 40243);
        assert Arrays.equals(r12, new int[]{});
        int[] r13 = obj.flip(t12, t12b, 80486);
        assert Arrays.equals(r13, t12);
        int[] r14 = obj.flip(t12, t12b, 0);
        int[] e14 = new int[t12.length];
        for (int i = 0; i < t12.length; i++) e14[i] = -t12[i];
        assert Arrays.equals(r14, e14);

        System.out.println("All tests passed.");
    }
}
