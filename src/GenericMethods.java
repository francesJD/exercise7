import java.util.*;

public class GenericMethods {
    // Write a generic method to count the number of elements in a collection that have a specific property
    public static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
    
    public static boolean isOddNumber(int num) {
        return num % 2 != 0;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }

    // Write a generic method to exchange the positions of two different elements in an array
    public static <T> void swap (T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void swap (List<T> l, int i, int j) {
        Collections.<T>swap(l, i, j);
    }

    // Write a generic method to find the maximal element in the range [begin, end) of a list.
    public static <T extends Comparable> T maxElement(java.util.List<T> list, int begin, int end) {
        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T element1 = list.get(i);
            if (element1.compareTo(max) > 0) {
                max = element1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Check even, odd, palindrome
        int evenNum = 2;
        System.out.println("The number " + evenNum + " is even: " + isEvenNumber(evenNum));

        System.out.println("The number " + evenNum + " is odd: " + isOddNumber(evenNum));

        String sPalindrome = "A man, a plan, a canal: Panama";
        System.out.println("The string " + "'" + sPalindrome + "'" + " is: " + isPalindrome(sPalindrome));
        System.out.println();

        // Test swap
        String [] sSwap1 = {"Hello", "INFO5100"};
        swap(sSwap1, 0, 1);
        System.out.println("sSwap1: " + Arrays.toString(sSwap1));
        List<String> sSwap2 = new ArrayList<String>(Arrays.asList(sSwap1));
        swap(sSwap2, 0, 1);
        System.out.println("sSwap2: " + sSwap2);
        System.out.println();

        // Test maxElement
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.print("The maximum number of the list in the range is: ");
        System.out.println(maxElement(list, 3, 13));
    }
}

