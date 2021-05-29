/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-05-10 19:45
 **/
public class Test4 {

    int binarySearch(int[] arr, int left, int right,int target){
        while(left < right){
            int middle = (left + right) /2;
            if(middle < 0 || middle >= arr.length) {
                return -1;
            }
            if(target == arr[middle]){
                return middle;
            }else if (target > arr[middle]){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return -1;

    }


    void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int ltmp = left;
        int rtmp = right;
        int middle = right;
        while(ltmp < rtmp){
            while(arr[ltmp] < arr[middle]){
                ltmp++;
            }
            if(ltmp <= arr.length-1 && arr[ltmp] > arr[middle]){
                swap(arr,ltmp,middle);
                middle = ltmp;
            }
            while(arr[rtmp] > arr[middle]){
                rtmp--;
            }
            if(rtmp >= 0 && arr[rtmp] < arr[middle]){
                swap(arr,rtmp,middle);
                middle = rtmp;
            }
        }

        quickSort(arr,left,middle-1);
        quickSort(arr,middle+1,right);
    }

    void swap(int[] arr, int l, int r){
        arr[l] ^= arr[r];
        arr[r] ^= arr[l];
        arr[l] ^= arr[r];
    }

}
