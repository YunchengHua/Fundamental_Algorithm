package Sort;

public class HeapSort {

    public static void heapSort(int[] arr){
        createMaxHeapFromArray(arr);
        for(int i = arr.length-1;i > 0;i--){
            swap(arr,0,i);
            heapify(arr,0,i-1);
        }
    }

    private static void heapify(int[] arr, int index,int limit){
        // int index = 0;
        // int childrenMax = Math.max((2*index+1) <= limit ? arr[2*index+1] : Integer.MIN_VALUE,(2*index+2) <= limit ? arr[2*index+2] : Integer.MIN_VALUE);
        // while(arr[index] < childrenMax){
        //     if(2*index+1 <= limit && 2*index+2 <= limit){
        //         int temp = (arr[2*index+1] > arr[2*index+2]) ? 2*index+1 : 2*index+2;
        //         swap(arr,index,temp);
        //         index = temp;
        //     }else if(2*index+1 <= limit){
        //         swap(arr,index,2*index+1);
        //         index = 2*index+1;
        //     }else{
        //         break;
        //     }

        //     childrenMax = Math.max((2*index+1) <= limit ? arr[2*index+1] : Integer.MIN_VALUE,(2*index+2) <= limit ? arr[2*index+2] : Integer.MIN_VALUE);
        // }

        int left = index * 2+1;
        while(left <= limit){
            int largetest = ((left + 1 <= limit) && arr[left+1] > arr[left]) ? left + 1 : left;
            largetest = (arr[index] < arr[largetest]) ? largetest : index;
            if(largetest == index)
                break;
            swap(arr,index,largetest);
            index = largetest;
            left = index * 2+1;
        }
    }

    private static void createMaxHeapFromArray(int[] arr){
        for(int i = 1;i < arr.length;i++){
            heapInsert(arr,i);
        }
    }

    private static void heapInsert(int[] arr,int t){
        while(arr[t] > arr[(t-1)/2]){
            swap(arr, t, (t-1)/2);
            t = (t - 1)/2;
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			heapSort(arr1);
			MyUtils.Test.sortComparator(arr2);
			if (!MyUtils.Test.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = MyUtils.Test.generateRandomArray(maxSize, maxValue);
		MyUtils.Test.printArray(arr);
		heapSort(arr);
		MyUtils.Test.printArray(arr);
	}
}