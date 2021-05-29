import org.junit.Test;

public class Test3 {

    @Test
    public void test(){
        int[] arr = new int[]{1,3,5,4,2};
        System.out.println(findKth(arr,5,4));
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        if(a == null) return -1;
        int index = n-K;
        if(index < 0) return -1;
        quickSort(a,0,a.length-1,index);
        return item;
    }

    int item = -1;
    void quickSort(int[] arr, int l,int r,int result){
        if (l > r) return;
        int middle = l;
        int key = arr[middle];
        int ltmp = l;
        int rtmp = r;
        while(ltmp < rtmp){
            while(ltmp < rtmp && key <= arr[rtmp]){
                rtmp--;
            }
            if(ltmp < rtmp){
                middle = rtmp;
                swap(arr ,ltmp, rtmp);
            }
            while(ltmp < rtmp && key >= arr[ltmp]){
                ltmp++;
            }
            if(ltmp < rtmp){
                middle = ltmp;
                swap(arr ,ltmp, rtmp);
            }
        }
        if(middle == result) {
            item =  arr[middle];
            return;
        }else if(middle < result){
            item =  arr[middle+1];
            quickSort(arr,middle+1,r,result);
        }else{
            item =  arr[middle-1];
            quickSort(arr,l,middle-1,result);
        }
    }

    public void swap(int[] arr ,int start, int end){
        arr[start] ^= arr[end];
        arr[end] ^= arr[start];
        arr[start] ^= arr[end];
    }

}
