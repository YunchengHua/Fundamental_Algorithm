package Sort;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        mergeSortHelper(arr,0,arr.length-1);

    }

    private static void mergeSortHelper(int[] arr,int L,int R){
        if(L == R){
            return;
        }
        int middle = L + ((R - L) >> 1);
        mergeSortHelper(arr,L,middle);
        mergeSortHelper(arr,middle+1,R);

        merge(arr,L,R);
    }

    private static void merge(int[] arr,int L,int R){
        int pL = L;
        int middle = L + ((R - L) >> 1);
        int pR = middle+1;
        
        int[] helper = new int[R - L + 1];
        int index = 0;

        while(pL <= middle && pR <= R){
            if(arr[pR] < arr[pL]){
                helper[index++] = arr[pR++];
            }else{
                helper[index++] = arr[pL++];
            }
        }

        while(pR <= R){
            helper[index++] = arr[pR++];
        }

        while(pL <= middle){
            helper[index++] = arr[pL++];
        }

        for(int i = 0;i < helper.length;i++){
            arr[L+i] = helper[i];
        }
    }

    public static void main(String args[]){
        int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			mergeSort(arr1);
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
		mergeSort(arr);
		MyUtils.Test.printArray(arr);
    }
}