import java.util.Scanner;
 
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        int testCase = sc.nextInt();
         
        for(int t = 1; t <= testCase; t++){
            int answer = 1;
            int[] colSumArray = new int[9];
            int[] smallSquareSumArray = new int[9];
            for(int i = 0; i < 9; i++){
                int rowSum = 0;
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = sc.nextInt();
                    rowSum+=sudoku[i][j];
                    colSumArray[j]+=sudoku[i][j];
                    if(i/3 == 0){
                        smallSquareSumArray[j/3] += sudoku[i][j];
                    } else if(i/3 == 1){
                        smallSquareSumArray[3+j/3] += sudoku[i][j];
                    } else{
                        smallSquareSumArray[6+j/3] += sudoku[i][j];
                    }
                }
                if(rowSum != 45){
                    answer = 0;
                }
            }
            for(int i = 0; i < colSumArray.length; i++){
                if(colSumArray[i] != 45 || smallSquareSumArray[i] != 45){
                    answer = 0;
                    if(answer == 0) break;
                }
            }
            System.out.println("#"+ t + " "+answer);
        }
    }
}