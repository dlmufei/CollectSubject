package other;
import java.util.Scanner;
public class Main01 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int b=scanner.nextInt();
		String string=scanner.next();
		while(scanner.hasNext()){
			int index=scanner.nextInt();
			String charStr=scanner.next();			
			StringBuffer buffer = new StringBuffer(string);			
			buffer.replace(index-1, index, charStr);			
			int count= f(buffer);
			System.out.println(count);			
			
		}
		
		
	}
	
	static int f(StringBuffer str){
		int count=0;
		int  start=-1;
		while((start=str.indexOf(".."))!=-1){
			count++;
			str.replace(start, start+2, ".");
			//System.out.println(str);
		}		
		return count;
	}
	

}
