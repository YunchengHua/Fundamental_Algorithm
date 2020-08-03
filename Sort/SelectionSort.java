package Sort;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			selectionSort(arr1);
			MyUtils.Test.sortComparator(arr2);
			if (!MyUtils.Test.isEqual(arr1, arr2)) {
				succeed = false;
				MyUtils.Test.printArray(arr1);
				MyUtils.Test.printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = MyUtils.Test.generateRandomArray(maxSize, maxValue);
		MyUtils.Test.printArray(arr);
		selectionSort(arr);
		MyUtils.Test.printArray(arr);
	}
}