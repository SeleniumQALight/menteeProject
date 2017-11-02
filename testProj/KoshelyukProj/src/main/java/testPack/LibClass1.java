package testPack;

/**
 * Created by Tetyana_Koshelyuk on 10/24/2017.
 */
public class LibClass1 {
    public int sum(int a, int b) {
        return (a + b);
    }

    public String sum(String a, String b) {
        return (a + b);
    }

    public int sum(String a, int b) {
        return (a.length() + b);
    }
}
