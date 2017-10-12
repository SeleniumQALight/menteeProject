package hw_lists;

import java.util.*;

abstract public class WorkWithAbstractList {
    /**
     *Method will add new List<String> to List
     */
    abstract void addNewList(List<List<String>> ourList);
    /**
     * Method should add value to some List
     * @param numberOfList
     * @param value
     */
    abstract void addValueToListList(int numberOfList, String value , List<List<String>> ourList);
    /**
     * Method should print Every List on new line
     */
    abstract void printListList(List<List<String>> ourList);

}
