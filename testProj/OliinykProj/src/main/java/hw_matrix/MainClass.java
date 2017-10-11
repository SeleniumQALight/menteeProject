package hw_matrix;

public class MainClass {

    public static void main(String[] args) {
        Model model = new Model();

        char[][] a = model.createArray(4,'X');
        model.printArray(a);
        model.fillDiag(a,'0');
        model.printArray(a);
    }
}
