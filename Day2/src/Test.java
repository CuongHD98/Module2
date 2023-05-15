import java.util.Scanner;
import java.lang.System;
public class Test {
    public static void main(String[] args) {
        int[] sourceArray = {2, 3, 1, 5, 10};
        int[] targetArray = new int[sourceArray.length];
        System.arraycopy(sourceArray,0,targetArray,0,sourceArray.length);
        for (int i = 0; i < targetArray.length; i++) {
            System.out.print(targetArray[i] + " ");
        }

    }
}
