import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
 
        int testCase = sc.nextInt();
        for(int t = 1; t <= testCase; t++){
             
            int matrixSize = sc.nextInt();
            // 입력받은 배열
            int[][] matrix = new int[matrixSize][matrixSize];
            // 회전 후 새로 저장할 배열
            int[][] newMatrix = new int[matrixSize][matrixSize];
            // 결과값 출력을 위한 배열
            String[][] printMatrix = new String[matrixSize][3];
            
            //2차원 배열 입력 받기
            for(int i = 0; i < matrixSize; i++){
                for(int j = 0; j < matrixSize; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            // 90도 180도 270도 회전을 위한 3 반복
            for(int i = 0; i < 3; i++){
                // 90도 회전시킨 행렬을 새 행렬에 입력
                for(int j = 0; j < matrixSize; j++){
                    for(int k = 0; k < matrixSize; k++){
                        newMatrix[k][matrixSize-(j+1)] = matrix[j][k];
                    }
                }
                // 기존 행렬에 90도 회전시킨 행렬값을 입력
                for(int j = 0; j < matrixSize; j++){
                	// 한 행 전체를 넣을 문자열
                    String printElement = "";
                    for(int k = 0; k < matrixSize; k++){
                        matrix[j][k] = newMatrix[j][k];
                        //90도 회전한 배열의 행의 원소들을 한 번에 묶기
                        printElement+=String.valueOf(newMatrix[j][k]);
                    }
                    // 한 행의 원소들을  한번에 새로운 배열에 넣기
                    printMatrix[j][i] = printElement;
                }
            }
            // printMatrix 배열에 90, 180, 270도 회전된 배열이 들어있음
            // 이를 출력
            System.out.println("#"+t);
            for(int i = 0; i < printMatrix.length; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(printMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}