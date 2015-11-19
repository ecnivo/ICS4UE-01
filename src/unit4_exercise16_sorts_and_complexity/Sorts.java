package unit4_exercise16_sorts_and_complexity;

import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		// int[] numbers = generateRandomNumberArray(10);
		int[] numbers = { 6, 2, 5, 0, 4, 3, 1 };
		long start = System.nanoTime();
		numbers = mergeSort(numbers);
		long end = System.nanoTime();

		printArray(numbers);
		System.out.println("The operation took " + (end - start) + " nanos");
	}

	public static int[] generateRandomNumberArray(int length) {
		boolean[] selected = new boolean[length];
		int[] returnArray = new int[length];
		for (int i = 0; i < length; i++) {
			int randomNum;
			do {
				randomNum = (int) (Math.random() * length);
			} while (selected[randomNum] == true);
			selected[randomNum] = true;
			returnArray[i] = randomNum;
		}
		return returnArray;
	}

	public static int[] mergeSort(int[] array) {
		if (array.length <= 1)
			return array;

		int middle = array.length / 2;
		int[] front = new int[middle];
		int[] back = new int[array.length - middle];
		for (int i = 0; i < middle; i++) {
			front[i] = array[i];
		}
		for (int i = middle; i < array.length; i++) {
			back[i - middle] = array[i];
		}

		return merge(front, back);
	}

	private static int[] merge(int[] front, int[] back) {
		int[] merged = new int[front.length + back.length];

		int i = 0;
		int frontI = 0;
		int backI = 0;

		while (frontI < front.length && backI < back.length) {
			if (front[frontI] > back[backI]) {
				merged[i] = front[frontI];
				frontI++;
			} else {
				merged[i] = back[backI];
				backI++;
			}
			i++;
		}

		while (frontI < front.length) {
			merged[i] = front[frontI];
			i++;
			frontI++;
		}
		while (backI < back.length) {
			merged[i] = back[backI];
			i++;
			backI++;
		}

		return merged;
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

}
