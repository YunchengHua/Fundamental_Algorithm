package Sort;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            // int index = i;
            // while(index > 0){
            //     if(arr[index] < arr[index - 1]){
            //         swap(arr,index,index-1);
            //         index --;
            //     }else{
            //         break;
            //     }
            // }
            for(int j = i;j > 0 && arr[j-1] > arr[j];j--){
                swap(arr,j,j-1);
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
			insertionSort(arr1);
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
		insertionSort(arr);
		MyUtils.Test.printArray(arr);
    }
}