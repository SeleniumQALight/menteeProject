package hw_lists;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        WorkWithList workWithList = new WorkWithList();
        List<List<String>> ourList = new ArrayList<List<String>>();

        workWithList.addNewList(ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(0,"test01",ourList);
        workWithList.printListList(ourList);

        workWithList.addNewList(ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(1,"test11",ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(1,"test12",ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(0,"test02",ourList);
        workWithList.printListList(ourList);

        workWithList.addNewList(ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(2,"test21", ourList);
        workWithList.printListList(ourList);
        workWithList.addValueToListList(1,"test13", ourList);
        workWithList.printListList(ourList);


    }
}
