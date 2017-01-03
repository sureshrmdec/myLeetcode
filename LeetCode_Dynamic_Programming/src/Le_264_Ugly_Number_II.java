/********
 * 
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

 * 
 * */

public class Le_264_Ugly_Number_II {	
	// 三指针，类似merge sort的思想
	public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        } else if(n <= 5){
            return n;
        }
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int currentIndex = 1;
        int currentValue = 0; 
        
        while(currentIndex < n){
            currentValue = Math.min(ugly[index2] * 2, Math.min(ugly[index3] * 3, ugly[index5] * 5));
            ugly[currentIndex++] = currentValue;
            
            if(ugly[index2] * 2 == currentValue){
                index2++;
            }
            if(ugly[index3] * 3 == currentValue){   // 这里不能用else， 因为ugly[index2 = 3] * 2和 ugly[index3 = 2] * 3时，
                index3++;                         // index2和index3两个都需要移动
            }
            if(ugly[index5] * 5 == currentValue){
                index5++;
            }
        }
        
        return ugly[n - 1];
    }
	
	
	
	
	
	
	
	
	
	/************************* main function **********************************/
	
	public static void main(String[] args){
		Le_264_Ugly_Number_II t = new Le_264_Ugly_Number_II();
		System.out.println(t.nthUglyNumber(6));
	}
}
