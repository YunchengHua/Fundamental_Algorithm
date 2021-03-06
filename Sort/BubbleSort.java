package Sort;

public class BubbleSort{
    public static void bubbleSort(int[] arr){
        int i = 0;
        int j = 0;
        for(i = arr.length; i > 1;i--){
            for(j = 1;j < i;j++){
                if(arr[j-1] > arr[j])
                    swap(arr,j-1,j);
            }
        }
        
    }

    public static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]){
        int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			bubbleSort(arr1);
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
		bubbleSort(arr);
		MyUtils.Test.printArray(arr);
    }
}