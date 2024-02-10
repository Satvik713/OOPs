public class Wifikey {
    public int[] mergeArrays(int[] arr1, int[] arr2, char c) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] mergedArray = new int[len1 + len2];

        if(c=='M')
        {
            for (int i = 0; i < len1; i++) 
            {
                mergedArray[i] = arr1[i];
            }

            for (int i = 0; i < len2; i++)
            {
                mergedArray[len1 + i] = arr2[i];
            }
        }
        if(c=='F')
        {
	        for (int i = 0; i < len2; i++) {
	            mergedArray[i] = arr2[i];
	        }

	        for (int i = 0; i < len1; i++) {
	            mergedArray[len2 + i] = arr1[i];
	        }
        }
        return mergedArray;
    }

    public int[] addArrays(char[] charArray, int[] secretKey) {
        int[] resultArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            resultArray[i] = (int) charArray[i] +secretKey[i];
        }

        return resultArray;
    }

    public long  convertArraytoNumber(int[] resultArray) {
    	if(resultArray.length == 0)	return 0L;
    	
        long  res = resultArray[0];
        for(int i=1;i<resultArray.length;i++)
        {
            long ele = resultArray[i];
            
            int cnt=0;
            
            while(ele>0)
            {
	            cnt++;
	            ele=ele/10;
            }
            
            ele = resultArray[i];
            
            long power=1;
            for(int k=0;k<cnt;k++)
            {
                power= power*10;
            }
            res= (res*power) + ele;
            
        }
        return res;
        
    }

    public float findUsername(byte grade, float cgpa){
        float userid= (float) (grade) + cgpa;
        return userid;
    }

    
}

