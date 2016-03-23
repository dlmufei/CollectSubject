package sort;
/**
 * 堆排序
 * 
 * 
 * @author FEI
 *
 */
public class HeapSort {
	
	public static void heapSort(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }
        //创建最大堆，整个数组全部算入堆内
        buildMaxHeap(array);  

        for (int i = array.length - 1; i >= 1; i--) { 
        	//通过交换，堆顶元素后移
            ArrayUtils.exchangeElements(array, 0, i);  
            //将已经排序好的元素，排除在建堆数组外
            maxHeap(array, i, 0);  
        }  
    }  

	/**
	 * 创建最大堆，整个数组全部算入堆内
	 * @param array
	 */
    private static void buildMaxHeap(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }  
        //从最后一个非叶子节点开始维护堆
        int half = array.length / 2;  
        for (int i = half; i >= 0; i--) {  
        	//array.length,整个数组全部算入堆内
            maxHeap(array, array.length, i);  
        }  
    }  

    /**
     * 根据给定的元素，维护堆，保证该节点以下保存最大堆
     * @param array
     * @param heapSize
     * @param index
     */
    private static void maxHeap(int[] array, int heapSize, int index) {  
    	//计算根节点的左右孩子的索引
        int left = index * 2 + 1;  
        int right = index * 2 + 2;  

        //假设，当前给定节点，就是最大值        
        int largest = index;  
        //判断左右孩子是否满足条件，记录其中最大值的索引
        //注意：递归要考虑，
        if (left < heapSize && array[left] > array[index]) {  
            largest = left;  
        } 
        if (right < heapSize && array[right] > array[largest]) {  
            largest = right;  
        } 
        //通过交换，构建最大堆。
        //发生交换以后，要递归的判断，交换的子节点是否满足最大堆，然后递归构造
        if (index != largest) {  
            ArrayUtils.exchangeElements(array, index, largest);  

            maxHeap(array, heapSize, largest);  
        }  
    }  

}
