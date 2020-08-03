package Sort;

public class QuickSort {

    public static void randomQuickSort(int[] arr){
        if(arr == null || arr.length  < 2) return;
        randomQuickSortHelper(arr,0,arr.length - 1);
    }

    public static void randomQuickSortHelper(int[] arr,int L,int R){
        if(L >= R){
            return;
        }
        int target = arr[(int) (Math.random()*(R-L+1))+L];
        int[] limit = partition(arr, target, L, R);
        randomQuickSortHelper(arr,L,limit[0]);
        randomQuickSortHelper(arr,limit[1],R);
    }

    public static int[] partition(int[] arr,int target,int L,int R){
        int left = L-1;
        int right = R+1;
        int index = L;

        while(index < right){
            if(arr[index] < target){
                swap(arr,index++,++left);
            }else if(arr[index] == target){
                index++;
            }else{
                swap(arr,index,--right);
            }
        }
    
        return new int[] {left,right};
    }

    public static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]){
        int testTime = 500000;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			randomQuickSort(arr1);
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
		randomQuickSort(arr);
		MyUtils.Test.printArray(arr);
    }
}