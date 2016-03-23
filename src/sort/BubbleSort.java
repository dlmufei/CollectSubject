package sort;

/**
 * 冒泡排序
 * 与相邻元素相比，通过交换获得最值
 * 
 * 冒泡排序是稳定的排序算法
 * @author FEI
 * 
 */
public class BubbleSort {

	public static void bubbleSort(int[] array) {
		if (array==null||array.length==1) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			//通过交换相邻元素，将最大值移到最后，
			//每次排序序列逐渐变短
			for (int j = 0; j < array.length-1; j++) {
				if (array[j]>array[j+1]) {
					int tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
				}
			}
		}

	}

}
