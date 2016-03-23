package sort;

/**
 * 快速排序 1、把数组拆分为两个子数组加上一个基准元素: 选取最后一个元素作为基准元素，index变量记录最近一个小于基准元素的元素所在的位置，
 * 初始化为start- 1，发现新的小于基准元素的元素，index加1。
 * 从第一个元素到倒数第二个元素，依次与基准元素比较，小于基准元素，index加1，交换位置index和当前位置的元素。
 * 循环结束之后index+1得到基准元素应该在的位置，交换index+1和最后一个元素。 2、分别排序[start, index], 和[index+2,
 * end]两个子数组
 * 
 * @author FEI
 * 
 */
public class QuickSort {

	public static void quickSort(int[] array) {
		subQuickSort(array, 0, array.length - 1); 
	}
	/**
	 * 子数组排序，递归实现
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void subQuickSort(int[] array, int start, int end) {
		if (array == null || (end - start + 1) < 2) {
			return;
		}
		//排序，并返回基准点索引
		int part = partition(array, start, end);

		//递归继续排序
		if (part == start) {
			subQuickSort(array, part + 1, end);
		} else if (part == end) {
			subQuickSort(array, start, part - 1);
		} else {
			subQuickSort(array, start, part - 1);
			subQuickSort(array, part + 1, end);
		}
	}

	/**
	 * 子数组排序具体实现
	 * @param array
	 * @param start 排序开始位置
	 * @param end 排序结束位置
	 * @return 排序数组最后一个元素（基准元素），排好序后所在的索引
	 */
	private static int partition(int[] array, int start, int end) {
		//基准元素
		int value = array[end];
		int index = start - 1;

		for (int i = start; i < end; i++) {
			if (array[i] < value) {
				//保证index以前的，都小于基准元素
				//如果元素大雨基准元素，index会记录，与下一个下于基准元素的值，交换，
				index++;
				if (index != i) {
					
					ArrayUtils.exchangeElements(array, index, i);
				}
			}
		}
		//经过一次循环以后，保证index+1指向的位置，就是基准元素，本应该在的位置
		if ((index + 1) != end) {
			ArrayUtils.exchangeElements(array, index + 1, end);
		}

		return index + 1;
	}

}
