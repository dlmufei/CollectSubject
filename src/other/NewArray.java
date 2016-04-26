package other;

import java.util.Scanner;

/**
 * Time Limit: 2000/2000 MS (Java/Others) Memory Limit: 32768/32768 K (Java/Others)
 * Problem Description:
 * 数列的定义如下：
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * 
 * 81 4
 * 2 2
 * 
 * 94.73
 * 3.41
 * 
 * @author FEI
 *
 */
public class NewArray {
	
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n=scanner.nextInt();
			int m=scanner.nextInt();
			double result=0;
			double b=n;
			for (int i = 0; i < m; i++) {
				result+= b;
				b=Math.sqrt(b);
			}
			System.out.printf("%.2f",result);
			System.out.println();
		}
		
		
	}

}
