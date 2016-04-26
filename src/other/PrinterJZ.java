package other;

import org.junit.Test;

/*对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。*/
public class PrinterJZ {

	public int[] clockwisePrint(int[][] mat, int n, int m) {
		int[] result = new int[m * n];
		int ltR = 0, ltC = 0;// 左上角的行号和列号
		int rbR = n - 1, rbC = m - 1;// 右下角的行号和列号
		int index = 0;// 记录当前输出数组的索引

		while (ltR <= rbR && ltC <= rbC) {
			if (ltR == rbR) {// 子矩阵只有一行
				for (int i = ltC; i <= rbC; i++) {
					result[index] = mat[ltR][i];
					index++;
				}
			} else if (ltC == rbC) {// 子矩阵只有一列
				for (int i = ltR; i <= rbR; i++) {
					result[index] = mat[i][ltC];
					index++;
				}
			} else {// 一般情况
				int curR = ltR;
				int curC = ltC;
				while (curC != rbC) {// 上面的一行
					result[index] = mat[curR][curC];
					curC++;
					index++;
				}
				while (curR != rbR) {// 右面的一列
					result[index] = mat[curR][curC];
					curR++;
					index++;
				}
				while (curC != ltC) {// 下面的一行
					result[index] = mat[curR][curC];
					curC--;
					index++;
				}
				while (curR != ltR) {// 左面的一列
					result[index] = mat[curR][curC];
					curR--;
					index++;
				}

			}

			ltC++;
			ltR++;
			rbC--;
			rbR--;

		}

		return result;

	}

	/*
	 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
	 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
	 */
	// [[1,2,3],[4,5,6],[7,8,9]],3
	// [[7,4,1],[8,5,2],[9,6,3]]
	public int[][] rotateMatrix(int[][] mat, int n) {
		int ltR = 0, ltC = 0;// 左上角的行号和列号
		int rbR = n - 1, rbC = n - 1;// 右下角的行号和列号
		while (ltR < rbR) {
			int count = rbR - ltR;// 要交换的数据组数
			for (int i = 0; i < count; i++) {
				int temp = mat[ltR][ltC + i];

				mat[ltR][ltC + i] = mat[rbR - i][ltC];//
				mat[rbR - i][ltC] = mat[rbR][rbC - i];//
				mat[rbR][rbC - i] = mat[ltR + i][rbC];
				mat[ltR + i][rbC] = temp;
			}
			ltC++;
			ltR++;
			rbC--;
			rbR--;

		}

		return mat;
	}

	/*
	 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
	 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
	 */
	// { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } },3,4
	// 1 2 5 9 6 3 4 7 10 11 8 12 
	public int[] printMatrix(int[][] mat, int n, int m) {
		int[] result = new int[m * n];
		int sr = 0, sc = 0;

		boolean startFlag = false;
		int index = 0;
		while (sr < n) {
			while (sc < m) {
				result[index] = mat[sr][sc++];
				index++;
			}
			sr++;
			while (sc > 0 && sr < n) {
				result[index] = mat[sr][--sc];
				index++;
			}
			sr++;

		}

		return result;
	}

	/*
	 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
	 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
	 */
	// [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
	// [1,2,3,6,5,4,7,8,9,12,11,10]
	public int[] printMatrix01(int[][] mat, int n, int m) {
		int[] result = new int[m * n];
		int ltR = 0, ltC = 0;// 左上角的行号和列号
		int rbR = 0, rbC = 0;// 右下角的行号和列号
		boolean startFlag = false;
		int index = 0;
		while (ltR != n) {
			int sr = ltR;
			int sc = ltC;
			int er = rbR;
			int ec = rbC;

			if (startFlag) {
				while (sr != er + 1) {
					result[index] = mat[sr++][sc--];
					index++;
				}
			} else {
				while (ec != sc + 1) {
					result[index] = mat[er--][ec++];
					index++;
				}
			}

			// 开始点，先按照行向右移动，再按照列向下移动
			if (ltC != m - 1) {
				ltC++;
			} else {
				ltR++;
			}
			// 结束点，先按照按照列向下移动，再行向右移动
			if (rbR != n - 1) {
				rbR++;
			} else {
				rbC++;
			}
			// 变换输出方向
			startFlag = !startFlag;

		}

		return result;
	}

	public void test01() {
		int[][] mat = { { 1, 2 }, { 3, 4 } };
		int n = 2;
		int m = 2;

		int[] result = clockwisePrint(mat, n, m);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public void test02() {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = 3;
		int[][] result = rotateMatrix(mat, n);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}

	}

	@Test
	public void test03() {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int n = 3;
		int m = 4;

		int[] result = printMatrix01(mat, n, m);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

}
