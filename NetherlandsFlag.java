public class NetherlandsFlag {
    public static int[] partition(int[] arr,int target){
        int left = -1;
        int right = arr.length;
        int index = 0;

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
		int maxSize = 20;
		int maxValue = 20;

        int[] arr = MyUtils.Test.generateRandomArray(maxSize, maxValue);
        MyUtils.Test.printArray(arr);
        int[] temp = partition(arr,12);
        MyUtils.Test.printArray(arr);
        System.out.println(temp[0]);
        System.out.println(temp[1]);
        
    }
}