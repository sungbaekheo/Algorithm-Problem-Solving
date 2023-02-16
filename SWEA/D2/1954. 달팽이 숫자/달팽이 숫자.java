import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1; t<=testCase; t++) {
			int size = sc.nextInt();
			int num = 1;
			int[][] snail = new int[size][size];
			
			int x = 0;
			int y = -1;
			int count = 0;
			int nSize = size;
			while(nSize>0) {
				if(nSize == size) {
					if(count%4 == 0) {
						for(int i=0; i<nSize; i++) {
							snail[x][++y] = num++;
						}
						count++;
					}
					nSize--;
				} else {
					for(int i=0; i<2; i++) {
						for(int j=0; j<nSize; j++) {
							if(count%4 == 0) {
								snail[x][++y] = num++;
							} else if(count%4 == 1) {
								snail[++x][y] = num++;
							} else if(count%4 == 2) {
								snail[x][--y] = num++;
							} else {
								snail[--x][y] = num++;
							}
						}
						count++;
					}
					nSize--;
				}
			}
			System.out.println("#"+t);
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					System.out.printf("%d ", snail[i][j]);
				}
				System.out.println();
			}
		}
	}
}