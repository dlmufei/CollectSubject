package other;

/**
 * 给定直方图，每一小块的height由N个非负整数所确定， 每一小块的width都为1，请找出直方图中面积最大的矩形。
 * 直方图中每一块的宽度都是1，每一块给定的高度分别是[2,1,5,6,2,3]： 返回10。
 * http://blog.csdn.net/jiyanfeng1/article/details/8067265
 * @author FEI
 * 
 */
public class LargestRectangleArea {

	public static int largestRectangleArea(int[] heights) {
		int area = 0;//最终最大面积
		for (int i = 0; i < heights.length; i++) {
			int width=1;//当前占用的宽度
			int currentArea=0;//当前面积
			
			//想前前搜寻
			for (int j = i-1; j >=0 ; j--) {
				if (heights[j]>=heights[i]) {
					width++;
				}else {
					break;
				}
			}
			
			//向后搜寻
			for (int j = i+1; j < heights.length; j++) {
				if (heights[j]>=heights[i]) {
					width++;
				}else {
					break;
				}
			}
			
			//计算当前对应的面积
			currentArea=heights[i]*width;
			if (currentArea>area) {
				area=currentArea;
			}			
		}

		return area;
	}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		System.err.println("给定数组的直方图最大面积为：" + largestRectangleArea(heights));
	}
}
