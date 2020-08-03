import java.util.Arrays;

public class MaxGap {
    public static int maxGap(int arr[]){
        if (arr == null || arr.length < 2) {
			return 0;
		}

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0;i < arr.length;i++){
            maxValue = Math.max(maxValue,arr[i]);
            minValue = Math.min(minValue,arr[i]);
        }

        int[][] buckets = new int[arr.length+1][3];
        for(int i = 0;i < arr.length;i++){
            int targetIndex = (int) ((arr[i] - minValue) * arr.length / (1.0*(maxValue - minValue)));
            buckets[targetIndex][0] = (buckets[targetIndex][2] == 0) ? arr[i] : Math.min(arr[i],buckets[targetIndex][0]);
            buckets[targetIndex][1] = (buckets[targetIndex][2] == 0) ? arr[i] : Math.max(arr[i],buckets[targetIndex][1]);
            buckets[targetIndex][2] = 1;
        }

        int res = 0;
        int lastMax = buckets[0][1];
        for(int i = 0;i < buckets.length;i++){
            if(buckets[i][2] == 1){
                res = Math.max(res,buckets[i][0] - lastMax);
                lastMax = buckets[i][1];
            }
        }


        return res;
    }

    public static int comparator(int arr[]){
        if (arr == null || arr.length < 2) {
			return 0;
        }
        
        Arrays.sort(arr);
        int res = Integer.MIN_VALUE;
        for(int i = 1;i < arr.length;i++){
            res = (arr[i] - arr[i-1] > res ? arr[i]-arr[i-1] : res);
        }
        return res;
    }

    public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyUtils.Test.generateRandomArray(maxSize, maxValue);
            int[] arr2 = MyUtils.Test.copyArray(arr1);
            int my = maxGap(arr1);
            int corretOne = comparator(arr2);
			if (my != corretOne) {
                succeed = false;
                System.out.println(i+":"+my+";"+corretOne);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}