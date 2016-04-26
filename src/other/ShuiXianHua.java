package other;

/**
 * Time Limit: 2000/2000 MS (Java/Others) Memory Limit: 32768/32768 K (Java/Others)
 * Problem Description:
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：
 * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
 * 现在要求输出所有在m和n范围内的水仙花数。
 * 
 * 100 120
 * 300 380
 * 输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。
 * 
 * no
 * 370 371
 */
import java.util.Scanner;

public class ShuiXianHua {
	
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){
			int m=scanner.nextInt();
			int n=scanner.nextInt();
			if (m>=100&&n>=m&&n<=999) {
				int count=0;
				for (int i = m; i <= n; i++) {
					int num1=i%10;
					int num2=i%100/10;
					int num3=i/100;
					int result=num1*num1*num1+num2*num2*num2+num3*num3*num3;
					if (result==i) {
						count++;
						if (count==0) {
							System.out.print(i);
						}else {
							System.out.print(" "+i);
						}
						
					}
				}
				
				if (count==0) {
					System.out.print("no");
				}
			}
			System.out.println();
			
		}
		
		
		
	}

}
