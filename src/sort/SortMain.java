package sort;

public class SortMain {
	
	public static void main(String[] args) {

		int[] array = { 1, 7, 5, 9, 3, 10, 2, 4, 5, 8, 11 };
		//InsertSort.insertSort(array);
		//SelectSort.selectSort(array);
		//BubbleSort.bubbleSort(array);
		//HeapSort.heapSort(array);
		QuickSort.quickSort(array);

		System.out.println("排序结果为：");
		ArrayUtils.printArray(array);
		
	}

}
