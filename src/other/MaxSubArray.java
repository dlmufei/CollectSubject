package other;

/**
 * 最大子数组问题
 * 
 * @author FEI
 * 
 */
public class MaxSubArray {

	public static class SubArray {
		int left;
		int right;
		int sum;

		public SubArray() {
			left = 0;
			right = 0;
			sum = Integer.MIN_VALUE;
		}
	}

	// *****************暴力求解*********************

	/**
	 *使用暴力求解，构建二重循环，枚举所有的字数组，记录最大值即可
	 * 
	 * @param array
	 */
	public static void maxSubArray1(int[] array, SubArray subArray) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += array[k];
				}
				if (sum > subArray.sum) {
					subArray.sum = sum;
					subArray.left = i;
					subArray.right = j;
				}
			}
		}

	}

	/**
	 *使用暴力求解，构建二重循环，枚举所有的字数组，记录最大值即可 注意：字数组求和的时候，可以优化
	 * 
	 * @param array
	 */
	public static void maxSubArray2(int[] array, SubArray subArray) {
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				if (sum > subArray.sum) {
					subArray.sum = sum;
					subArray.left = i;
					subArray.right = j;
				}
			}
		}
	}

	// ***************递归求解*************
	/**
	 * 
	 */
	public static SubArray maxSubArray(int[] array,int low,int height) {
		SubArray subArray=new SubArray();
		if (low==height) {
			subArray.left=low;
			subArray.right=height;
			subArray.sum=array[low];
			return subArray;
		}
		int mid=(low+height)/2;
		SubArray leftArray=maxSubArray(array, low, mid);
		SubArray rightArray=maxSubArray(array, mid, height);
		SubArray midArray=maxCrossSubArray(array, low, mid, height);
		
		if (leftArray.sum>rightArray.sum&&leftArray.sum>midArray.sum) {
			return leftArray;
		}else if (rightArray.sum>midArray.sum&&rightArray.sum>leftArray.sum) {
			return rightArray;
		}else {
			return midArray;
		}
		
		
		
		

	}

	/**
	 * 查找跨越重点的最大字数组
	 * @param array
	 * @param low
	 * @param mid
	 * @param height
	 * @return
	 */
	public static SubArray maxCrossSubArray(int[] array,int low,int mid,int height) {
		SubArray subArray=new SubArray();
		int leftSum=Integer.MIN_VALUE;
		int sum=0;
		for (int i = mid; i < low; i--) {
			sum+=array[i];
			if (sum>leftSum) {
				leftSum=sum;
				subArray.left=i;
			}
		}
		int rightSum=Integer.MIN_VALUE;
		sum=0;
		for (int i = mid+1; i < height; i++) {
			sum+=array[i];
			if (sum>rightSum) {
				rightSum=sum;
				subArray.right=i;
			}
		}		
		subArray.sum=leftSum+rightSum;
		return subArray;

	}

	// *****************动态规划*********************
	/**
	 * 这种方法有一个问题，全部是负数的时候怎么办？ 最后要判断，如果最小值是负数时，最大字数组就是最大的元素值
	 */
	public static void maxSubArray3(int[] array, SubArray subArray) {
		int sum = array[0];
		subArray.sum = array[0];
		subArray.left = 0;
		for (int i = 1; i < array.length; i++) {
			if (sum < 0) {
				sum = 0;
				subArray.left = i;
			}
			sum += array[i];
			if (sum > subArray.sum) {
				subArray.sum = sum;
				subArray.right = i;
			}
		}

	}

	public static void main(String[] args) {

		int[] array = { 1, -2, 3, 5, -3, 2 };
		int[] array1 = { 0, -2, 3, 5, -1, 2 };
		int[] array2 = { -9, -2, -3, -5, -1, -2 };
		SubArray subArray = new SubArray();

		// maxSubArray1(array, subArray);
		// maxSubArray2(array, subArray);
		//maxSubArray3(array2, subArray);
		subArray= maxSubArray(array, 0, array.length);
		System.out.println("left:" + subArray.left + " right:" + subArray.right
				+ " sum:" + subArray.sum);

	}

}
