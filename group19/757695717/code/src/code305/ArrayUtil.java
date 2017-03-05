package code305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * ArrayUtil.java
 * @author dushuai
 * @desc 数组操作工具
 * @datatime 2017.03.05
 *
 */
public class ArrayUtil {
	
	public static int[] swap(int[] Duarray,int x,int y)
	{
		int temp = Duarray[x];
		Duarray[x] = Duarray[y];
		Duarray[y] = temp;
		return Duarray;
	}
	/********************************************************
	 * 排序算法
	 *********************************************************/
	//冒泡排序
	public static int[] bubbleSort(int[] Duarray)
	{
		int temp = 0;
		for(int i = Duarray.length;i > 0;--i)
		{
			for(int j = 0;j < i;j++)
			{
				if(Duarray[j] < Duarray[j+1])
				{
					swap(Duarray,j,j+1);
				}
			}
		}
		return Duarray;
	}

	//插入算法排序
	public static int[] insectSort(int[] Duarray)
	{
		for(int i = 1;i < Duarray.length;i++)
		{
			for(int j = i;(j > 0) && (Duarray[j] < Duarray[j-1]);j--)
			{
				swap(Duarray,j,j-1);
			}
		}
		
		return Duarray;
	}
	
	//快排
	public static int[] quickSort(int[] Duarray)
	{
		return qsort(Duarray,0,Duarray.length - 1);
	}
	
	//快排的具体实现
	 private static int[] qsort(int source[], int low, int high) {    
	        int i, j, x;    
	        if (low < high) {    
	            i = low;    
	            j = high;    
	            x = source[i];    
	            while (i < j) {    
	                while (i < j && source[j] > x) {    
	                    j--;    
	                }    
	                if (i < j) {    
	                    source[i] = source[j];    
	                    i++;    
	                }    
	                while (i < j && source[i] < x) {    
	                    i++;    
	                }    
	                if (i < j) {    
	                    source[j] = source[i];    
	                    j--;    
	                }    
	            }    
	            source[i] = x;    
	            qsort(source, low, i - 1);    
	            qsort(source, i + 1, high);    
	        }    
	        return source;    
	    }    
	
	/**********************************************************
	 * 查找算法
	 * 
	 ***********************************************************/
	/*************************************************************
	 * 二分法查找
	 ****************************************************************/
	public static int binarySearch(int[] Duarray,int key)
	{
		int low = 0,higth = Duarray.length - 1,mid = 0;
		while(low <= higth)
		{
			mid = (low + higth) >>> 1;
			if(key == Duarray[mid])
			{
				return mid;
			}
			else if(key <= Duarray[mid])
			{
				higth = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		
		return -1;
	}
	/*************************************************************************************
	 * 反转数组
	 * ********************************************************************************** */
	public static int[] reverse(int[] Duarray)
	{
		int length = Duarray.length;
		int temp = 0;
		for(int i = 0; i < length>>1 ;i++)
		{
			temp = Duarray[i];
			Duarray[i] = Duarray[length - i - 1];
			Duarray[length - i - 1] = temp;
		}
		return Duarray;
	}
	
	/**************************************************************************
	 * 在当前数组中插入一个元素
	 ******************************************************************************/
	public static int[] insert(int[] array, int index, int insertNumber) {    
        if (array == null || array.length == 0) {    
            throw new IllegalArgumentException();    
        }    
        if (index-1 > array.length || index <= 0) {    
            throw new IllegalArgumentException();    
        }    
        int[] dest=new int[array.length+1];    
        System.arraycopy(array, 0, dest, 0, index-1);    
        dest[index-1]=insertNumber;    
        System.arraycopy(array, index-1, dest, index, dest.length-index);    
        return dest;    
    }    
	/**  
     * 整形数组中特定位置删除掉一个元素,数组中原有元素向前移动;  
     * 如果插入位置超出原数组，则抛IllegalArgumentException异常  
     * @param array  
     * @param index  
     * @return  
     */    
    public static int[] remove(int[] array, int index) {    
        if (array == null || array.length == 0) {    
            throw new IllegalArgumentException();    
        }    
        if (index > array.length || index <= 0) {    
            throw new IllegalArgumentException();    
        }    
        int[] dest=new int[array.length-1];    
        System.arraycopy(array, 0, dest, 0, index-1);    
        System.arraycopy(array, index, dest, index-1, array.length-index);    
        return dest;    
    }    
    
    /**  
     * 2个数组合并，形成一个新的数组  
     * @param array1  
     * @param array2  
     * @return  
     */    
    public static int[] merge(int[] array1,int[] array2) {    
        int[] dest=new int[array1.length+array2.length];    
        System.arraycopy(array1, 0, dest, 0, array1.length);    
        System.arraycopy(array2, 0, dest, array1.length, array2.length);    
        return dest;    
    }    
    
/**  
     * 数组中有n个数据，要将它们顺序循环向后移动k位，  
     * 即前面的元素向后移动k位，后面的元素则循环向前移k位，  
     * 例如，0、1、2、3、4循环移动3位后为2、3、4、0、1。  
     * @param array  
     * @param offset  
     * @return  
     */    
    public static int[] offsetArray(int[] array,int offset){    
        int length = array.length;      
        int moveLength = length - offset;     
        int[] temp = Arrays.copyOfRange(array, moveLength, length);    
        System.arraycopy(array, 0, array, offset, moveLength);      
        System.arraycopy(temp, 0, array, 0, offset);    
        return array;    
    }    
    /**  
     * 随机打乱一个数组  
     * @param list  
     * @return  
     */    
    public static List shuffle(List list){    
        java.util.Collections.shuffle(list);    
        return list;    
    }    
    
    /**  
     * 随机打乱一个数组  
     * @param array  
     * @return  
     */    
    public int[] shuffle(int[] array) {    
        Random random = new Random();    
        for (int index = array.length - 1; index >= 0; index--) {    
            // 从0到index处之间随机取一个值，跟index处的元素交换    
            exchange(array, random.nextInt(index + 1), index);    
        }    
        return array;    
    }    
    
    // 交换位置    
    private void exchange(int[] array, int p1, int p2) {    
        int temp = array[p1];    
        array[p1] = array[p2];    
        array[p2] = temp;    
    }    
/**  
     * 对两个有序数组进行合并,并将重复的数字将其去掉  
     *   
     * @param a：已排好序的数组a  
     * @param b：已排好序的数组b  
     * @return 合并后的排序数组  
     */    
    private static List<Integer> mergeByList(int[] a, int[] b) {    
        // 用于返回的新数组，长度可能不为a,b数组之和，因为可能有重复的数字需要去掉    
        List<Integer> c = new ArrayList<Integer>();    
        // a数组下标    
        int aIndex = 0;    
        // b数组下标    
        int bIndex = 0;    
        // 对a、b两数组的值进行比较，并将小的值加到c，并将该数组下标+1，    
        // 如果相等，则将其任意一个加到c，两数组下标均+1    
        // 如果下标超出该数组长度，则退出循环    
        while (true) {    
            if (aIndex > a.length - 1 || bIndex > b.length - 1) {    
                break;    
            }    
            if (a[aIndex] < b[bIndex]) {    
                c.add(a[aIndex]);    
                aIndex++;    
            } else if (a[aIndex] > b[bIndex]) {    
                c.add(b[bIndex]);    
                bIndex++;    
            } else {    
                c.add(a[aIndex]);    
                aIndex++;    
                bIndex++;    
            }    
        }    
        // 将没有超出数组下标的数组其余全部加到数组c中    
        // 如果a数组还有数字没有处理    
        if (aIndex <= a.length - 1) {    
            for (int i = aIndex; i <= a.length - 1; i++) {    
                c.add(a[i]);    
            }    
            // 如果b数组中还有数字没有处理    
        } else if (bIndex <= b.length - 1) {    
            for (int i = bIndex; i <= b.length - 1; i++) {    
                c.add(b[i]);    
            }    
        }    
        return c;    
    }    
    /**  
     * 对两个有序数组进行合并,并将重复的数字将其去掉  
     * @param a:已排好序的数组a  
     * @param b:已排好序的数组b  
     * @return合并后的排序数组,返回数组的长度=a.length + b.length,不足部分补0  
     */    
    private static int[] mergeByArray(int[] a, int[] b){    
        int[] c = new int[a.length + b.length];    
    
        int i = 0, j = 0, k = 0;    
    
        while (i < a.length && j < b.length) {    
            if (a[i] <= b[j]) {    
                if (a[i] == b[j]) {    
                    j++;    
                } else {    
                    c[k] = a[i];    
                    i++;    
                    k++;    
                }    
            } else {    
                c[k] = b[j];    
                j++;    
                k++;    
            }    
        }    
        while (i < a.length) {    
            c[k] = a[i];    
            k++;    
            i++;    
        }    
        while (j < b.length) {    
            c[k] = b[j];    
            j++;    
            k++;    
        }    
        return c;    
    }    
    /**  
     * 对两个有序数组进行合并,并将重复的数字将其去掉  
     * @param a：可以是没有排序的数组  
     * @param b：可以是没有排序的数组  
     * @return合并后的排序数组  
     * 打印时可以这样：  
     * Map<Integer,Integer> map=sortByTreeMap(a,b);  
        Iterator iterator =  map.entrySet().iterator();     
        while (iterator.hasNext()) {     
           Map.Entry mapentry = (Map.Entry)iterator.next();     
           System.out.print(mapentry.getValue()+" ");     
        }  
     */    
    private static Map<Integer,Integer> mergeByTreeMap(int[] a, int[] b) {    
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();    
        for(int i=0;i<a.length;i++){    
            map.put(a[i], a[i]);    
        }    
        for(int i=0;i<b.length;i++){    
            map.put(b[i], b[i]);    
        }    
        return map;    
    }    
    /**  
     * 在控制台打印数组，之间用逗号隔开,调试时用  
     * @param array  
     */    
    public static String print(int[] array){    
        StringBuffer sb=new StringBuffer();    
        for(int i=0;i<array.length;i++){    
            sb.append(","+array[i]);    
        }    
        System.out.println(sb.toString().substring(1));    
        return sb.toString().substring(1);    
    }    
    public static void main(String[] args){    
        ArrayUtil util=new ArrayUtil();    
        int[] array0={21,24,13,46,35,26,14,43,11};    
        int[] array1={1,2,3,4,5,6};    
        int[] array2={11,22,33,44,55,66};    
        int[] temp=util.quickSort(array0);    
        print(temp);    
            
    }    


}
