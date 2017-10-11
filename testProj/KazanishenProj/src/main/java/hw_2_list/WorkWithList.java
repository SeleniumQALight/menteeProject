package hw_2_list;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList extends WorkWithAbstractList{

    public List<List<String>> addNewList(List<List<String>> ourList){
        List<String> list = new ArrayList<String>();
        ourList.add(list);
        printListList(ourList);
        return ourList;
    }

    public List<List<String>> addValueToListList(int numberOfList, String value , List<List<String>> ourList){
        ourList.get(numberOfList).add(value);
        printListList(ourList);
        return ourList;
    }

    public void printListList(List<List<String>> ourList){
        System.out.println("---------");
        for(int i =0; i < ourList.size(); i++){
            if (ourList.get(i).size() == 0){
                System.out.print("[]");
            }
            else {
                for(int j = 0; j < ourList.get(i).size(); j++) {
                    System.out.print("["+ourList.get(i).get(j)+"]");
                    if (j != (ourList.get(i).size() - 1)){
                        System.out.print(", ");
                    }
                }
            }
            System.out.println();
        }
    }


    // Home work part 2
     public static int[][] generateTwoDimensionalArray(int sizeX, int sizeY, int value) throws Exception{
        if(sizeX == 0 || sizeY == 0){
            throw new Exception("Incorrect matrix size");
            }
        else{
            int[][] arr = new int[sizeX][sizeY];
            for (int i =0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    arr[i][j] = value;
                }
            }
            return arr;
            }
     }
     public static void printArray(int[][] arr){
         for (int i =0; i < arr.length; i++){
             for (int j = 0; j < arr[i].length; j++){
                 System.out.print(arr[i][j]);
             }
             System.out.println();
         }
         System.out.println();
     }
     public static void putValueInArrayDiagonal(int[][] arr, int value){
         try{
             if (arr.length != arr[0].length){
                 throw new Exception();
             }
             for (int i =0; i < arr.length; i++){
                 arr[i][i] = value;
             }
         }
         catch (Exception ex){
             System.out.println("It is not square matrix.");
         }
     }

    public static void main(String[] args) {
        WorkWithList workWithList = new WorkWithList();
        List<List<String>> ourList = new ArrayList<List<String>>();

        workWithList.addNewList(ourList);
        ourList = workWithList.addValueToListList(0,"test01",ourList);

        workWithList.addNewList(ourList);
        ourList = workWithList.addValueToListList(1,"test11",ourList);
        ourList = workWithList.addValueToListList(1,"test12",ourList);
        ourList = workWithList.addValueToListList(0,"test02",ourList);

        workWithList.addNewList(ourList);
        workWithList.addValueToListList(2,"test21", ourList);
        workWithList.addValueToListList(1,"test13", ourList);



        // Home work part 2

        int[][] arr;
        try{
            arr = generateTwoDimensionalArray(5,4, 5);
            printArray(arr);
            putValueInArrayDiagonal(arr, 1);
            printArray(arr);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }






    }
}
