package hw_matrix;

class Model {

    char[][] createArray(int n, char value){
        char[][] a = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] = value;
            }
        }
        return a;
    }

    void fillDiag(char[][] a, char value){
        for(int i=0;i<a.length;i++){
            a[i][i] = value;
        }
    }

    void printArray(char[][] a){
        for(char [] line : a){
            for(char symbol : line){
                System.out.print(symbol+ " ");
            }
            System.out.println("");
        }
    }
}
