package hw_lists;

import java.util.*;
public class WorkWithList extends WorkWithAbstractList {

    public void addNewList(List<List<String>> ourList){
        List<String> subList = new ArrayList<String>() ;
        ourList.add(subList);
    }

    public void addValueToListList(int numberOfList, String value , List<List<String>> ourList){
        if (numberOfList>=ourList.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Iterator<List<String>> iter = ourList.iterator();
        int i = -1;
        while(iter.hasNext()&&i<numberOfList){
           iter.next();
           i++;
        }
        ourList.get(i).add(value);
    }

    void printListList(List<List<String>> ourList){
        System.out.println("---------");
        for(List<String> l : ourList){
            System.out.print("[");
            String out = "";
            int i =0;
            for(String s : l){
                if(i==0||i==l.size()) {
                    out += s;
                }
                else {
                    out+=", "+s;
                }
                i++;
            }
            System.out.println(out+"]");
        }
    }
}
