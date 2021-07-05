package HomeWorkLesson5;

import java.util.Arrays;
public class AppGo {

    public static void main(String[] args) throws InterruptedException {

        MainApp1 mainApp1 = new MainApp1();
        MainApp2 mainApp2 = new MainApp2();

        mainApp1.start();
        mainApp1.join();
        mainApp2.start();
        mainApp2.join();
    }


    static class MainApp1 extends Thread {
        float[] arr1 = new float[1000000];
        public MainApp1(){
            this.arr1=arrOne();
        }

        @Override
        public void run() {
            arrOne();
            float[] a1 = arrOne();
        }

        float[] arrOne() {
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

        public float[] getArr1() {
            return arr1;
        }
    }

    static class MainApp2 extends Thread {
        float[] arr = new float[10000];

        public MainApp2 (){
            this.arr = arrTwo();
        }

        @Override
        public void run() {
            arrTwo();
            float[] a2 = arrTwo();
        }

        float[] arrTwo() {

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1.0f;
            }
            long startTime = System.currentTimeMillis();
            System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
            return arr;
        }

        public float[] getArr() {
            return arr;
        }
    }

    }

    class Split extends Thread {

    AppGo.MainApp1 a1 = new AppGo.MainApp1();
    AppGo.MainApp2 a2 = new AppGo.MainApp2();


    @Override
    public void run() {
        splitArr(a1.getArr1(), a2.getArr(), 10);
    }

        private void splitArr(float[] initialArray, float[] mergedArray, int s) {
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