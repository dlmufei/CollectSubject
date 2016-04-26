package other;

import org.junit.Test;

/*对于一个字符串，和字符串中的某一位置，请设计一个算法，将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。*/
//"ABCDEFGH",8,4
//"FGHABCDE"

public class StringRotation {

	@Test
	public void rotateString() {
		
		String A="ABCDEFGH";
		int n=8;
		int p=4;
		
		String strResult=null;
		strResult=A.substring(p+1)+A.substring(0,p+1);
		
		
		System.out.println(strResult);
		
		
		

	}

}
