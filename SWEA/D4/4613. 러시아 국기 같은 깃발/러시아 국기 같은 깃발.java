import java.util.Scanner;

public class Solution {
	static int col;
	static String[][] flag;
	static int minCount = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1; t<=testCase; t++) {
			minCount = Integer.MAX_VALUE;
			int row = sc.nextInt();
			col = sc.nextInt();
			flag = new String[row][col];
			
			for(int r=0; r<row; r++) {
				flag[r] = sc.next().split("");
			}
			int count = 0;
			
			paint("", "W", row-1, count);
			
			System.out.println("#" + t + " " + minCount);
		}
	}
	
	static void paint(String order, String add, int row, int count) {
		order+=add;
		if(row == 1) {
			order+="R";
			for(int i=0; i<order.length(); i++) {
				for(int j=0; j<col; j++) {
					if(!String.valueOf(order.charAt(i)).equals(flag[i][j])) {
						count++;
					}
				}
			}
			if(count<minCount) {
				minCount = count;
			}
			return;
		}
		if(order.substring(order.length()-1,order.length()).equals("W")) {
			if(row>2) {
				paint(order, "W", row-1, count);
			}
			paint(order, "B", row-1, count);
		} else if(order.substring(order.length()-1,order.length()).equals("B")) {
			paint(order, "B", row-1, count);
			paint(order, "R", row-1, count);
		} else {
			paint(order, "R", row-1, count);
		}
	}
}