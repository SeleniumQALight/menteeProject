package hw_2_list;

import java.util.List;

abstract public class WorkWithAbstractList{
    abstract List<List<String>> addNewList(List<List<String>> ourList);
    abstract List<List<String>> addValueToListList(int numberOfList, String value , List<List<String>> ourList);
    abstract void printListList(List<List<String>> ourList);

}
