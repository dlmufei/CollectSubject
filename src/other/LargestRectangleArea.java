package other;

import java.util.Stack;
import java.lang.Integer;

/**
 * 给定直方图，每一小块的height由N个非负整数所确定， 每一小块的width都为1，请找出直方图中面积最大的矩形。
 * 直方图中每一块的宽度都是1，每一块给定的高度分别是[2,1,5,6,2,3]： 返回10。
 * http://blog.csdn.net/jiyanfeng1/article/details/8067265
 * 
 * @author FEI
 * 
 */
public class LargestRectangleArea {

	public static int largestRectangleArea(int[] heights) {
		int area = 0;// 最终最大面积
		for (int i = 0; i < heights.length; i++) {
			int width = 1;// 当前占用的宽度
			int currentArea = 0;// 当前面积

			// 想前前搜寻
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] >= heights[i]) {
					width++;
				} else {
					break;
				}
			}

			// 向后搜寻
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[j] >= heights[i]) {
					width++;
				} else {
					break;
				}
			}

			// 计算当前对应的面积
			currentArea = heights[i] * width;
			if (currentArea > area) {
				area = currentArea;
			}
		}

		return area;
	}

	/**
	 * http://www.acmerblog.com/largest-rectangle-in-histogram-6117.html
	 * 栈内存储的是高度递增的下标。
	 * 对于每一个直方图高度，分两种情况:
	 * 1：当栈空或者当前高度大于栈顶下标所指示的高度时，当前下标入栈。否则，
	 * 2：当前栈顶出栈，并且用这个下标所指示的高度计算面积。
	 * 而这个方法为什么只需要一个栈呢？因为当第二种情况时，
	 * for循环的循环下标回退，也就让下一次for循环比较当前高度与新的栈顶下标所指示的高度，
	 * 注意此时的栈顶已经改变由于之前的出栈。
	 * @param height
	 * @return
	 */
	public static int largestRectangleArea1(int[] height) {
			  int area = 0;		
			  Stack<Integer> stack = new Stack<Integer>();	
			  for (int i = 0; i < height.length; i++) {		
			    if (stack.empty() || height[stack.peek()] < height[i]) {		
			      stack.push(i);		
			    } else {		
			      int start = stack.pop();		
			      int width = stack.empty() ? i : i - stack.peek() - 1;		
			      area = Math.max(area, height[start] * width);		
			      i--;		
			    }		
			  }
		
			  while (!stack.empty()) {		
			    int start = stack.pop();		
			    int width = stack.empty() ? height.length : height.length - stack.peek() - 1;		
			    area = Math.max(area, height[start] * width);		
			  }		
			  return area;		
			}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		System.err.println("给定数组的直方图最大面积为：" + largestRectangleArea(heights));
		System.err.println("给定数组的直方图最大面积为：" + largestRectangleArea1(heights));
		
	}
}
