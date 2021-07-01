package HomeWorkLesson5;

import java.util.Arrays;

public class ThreadHomework5 {
    public static void main(String[] args) {
        int size = 10;
        float[] a1 =  firstMethod(size);
        float[] a2 = secondMethod(size);
        splitAndMergeExample(a1, a2, size);
    }

    private static void splitAndMergeExample(float[] firstMethod, float[] secondMethod) {
    }

    public static float[] firstMethod(int size) {
        float[] arr1 = new float[size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

        return arr1;
    }

    public static float[] secondMethod(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

        return arr;
    }

    public static void splitAndMergeExample(float[] initialArray, float[] mergedArray, int s) {

        int h = s / 2;

        System.out.println(Arrays.toString(initialArray));

        float[] leftHalf = new float[h];
        float[] rightHalf = new float[h];
        System.arraycopy(initialArray, 0, leftHalf, 0, h);
        System.arraycopy(initialArray, h, rightHalf, 0, h);
        System.out.println(Arrays.toString(leftHalf));
        System.out.println(Arrays.toString(rightHalf));


        System.arraycopy(leftHalf, 0, mergedArray, 0, h);
        System.arraycopy(rightHalf, 0, mergedArray, h, h);
        System.out.println(Arrays.toString(mergedArray));
    }



}

