package hw_2_list;

import java.util.ArrayList;
import java.util.List;

public class myClass {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();

        myList.add("1");
        myList.add("2");
        myList.add("3");

        for (String i:myList) {
            System.out.println(i);
        }
    }
}
