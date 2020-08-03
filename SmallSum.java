public class SmallSum {

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2) {
			return 0;
		}

        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr,int L,int R){
        if(L == R){
            return 0;
        }

        int M = L + ((R-L) >> 1);
        return mergeSort(arr, L, M) + mergeSort(arr, M+1, R) + merge(arr, L, R);
    }

    private static int merge(int[] arr,int L,int R){
        int res = 0;
        int pL = L;
        int M = L + ((R - L) >> 1);
        int pR = M+1; 
        int index = 0;
        int[] helper = new int[R-L+1];

        while(pL <= M && pR <= R){
            if(arr[pL] < arr[pR]){
                res += arr[pL] * (R-pR+1);
                helper[index++] = arr[pL++];
            }else{
                helper[index++] = arr[pR++];
            }
        }


        while(pR <= R){
            helper[index++] = arr[pR++];
        }

        while(pL <= M){
            helper[index++] = arr[pL++];
        }

        for(int i = 0;i < helper.length;i++){
            arr[L+i] = helper[i];
        }

        return res;
    }

    public static int comparator(int[] arr){
        if (arr == null || arr.length < 2) {
			return 0;
        }
        
        int sum = 0;
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < i;j++){
                if(arr[j] < arr[i]){
                    sum += arr[j];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
			int[] arr2 = MyUtils.Test.copyArray(arr1);
			if (smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				MyUtils.Test.printArray(arr1);
				MyUtils.Test.printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}