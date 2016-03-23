package sort;
/**
 * 选择排序：与指定位置的元素相比，每次通过比较，交换得到最大或者最小值
 * 将初始序列(A[0]~A[n-1])作为待排序序列，第一趟在待排序序列(A[0]~A[n-1])中找到最小值元素，
 * 将其与第一个元素A[0]交换，这样子序列(A[0])已经有序，下一趟在排序在待排序子序列(A[1]~A[n-1])中进行。
 * 第i趟排序在待排序子序列(A[i-1]~A[n-1])中找到最小值元素，
 * 与该子序列中第一个元素A[i-1]交换。经过 n-1 趟排序后使得初始序列有序。
 * 
 * 不稳定的排序算法
 * @author FEI
 *
 */
public class SelectSort {
	public static void selectSort(int[] array) {
		if (array==null||array.length==1) {
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			//i后面的元素依次与第i个元素比较，获得最大值
			for (int j = i+1; j < array.length; j++) {
				if (array[j]<array[i]) {
					int tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
			}
		}
	}

}
