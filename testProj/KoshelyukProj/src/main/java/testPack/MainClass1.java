package testPack;

/**
 * Created by Tetyana_Koshelyuk on 10/24/2017.
 */
public class MainClass1 {
    public static void main(String[] args) {
        int rez1;
        String rez2;
        int rez3;
        int rez4;
        LibClass1 a, libClass;
        int arr[] = { 2, 4, 26, 7, 28, 10, 9, 20, 33 };
        int len = arr.length;

        a = new LibClass1();
        rez1 = a.sum("asdf", 1);
        System.out.println(rez1);
        rez2 = a.sum("a", "b");
        System.out.println(rez2);
        rez3 = a.sum(1, 1);
        System.out.println(rez3);

        for (int i = 0; i < len; i++) {
            if (arr[i] < 10) {
                System.out.println("element < 10" + " " + arr[i]);
            } else if (arr[i] > 10) {
                System.out.println("element > 10" + " " + arr[i]);
            } else if (arr[i] == 10) {
                System.out.println("element = 10" + " " + arr[i]);
            }
        }
    }
}
