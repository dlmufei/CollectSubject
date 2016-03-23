package sort;
/**
 * 排序工具类
 * @author FEI
 *
 */
public class ArrayUtils {
	/**
	 * 输出数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	/**
	 * 交换数组制定索引的值
	 * @param array
	 * @param index1
	 * @param index2
	 */
	public static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
