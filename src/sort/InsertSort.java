package sort;
/**
 * 插入排序
 * 将初始序列中的第一个元素作为一个有序序列，
 * 然后将剩下的 n-1 个元素按关键字大小依次插入该有序序列，
 * 每插入一个元素后依然保持该序列有序，经过 n-1 趟排序后使初始序列有序。
 * 
 * 插入排序是稳定的排序算法
 * @author FEI
 *
 */
public class InsertSort {
	
	
	public static void insertSort(int[] array) {
		if (array==null||array.length==1) {
			return;
		}		
		for (int i = 1; i < array.length; i++) {
			int key=array[i];
			int j=i-1;
			
			//从要调整的关键字的后一位开始逐步和前面的比较，找到插入位置，
			//通过交换，达到插入的目的
			while(j>=0&&array[j]>key){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;				
		}
		
	}
	

	

}
