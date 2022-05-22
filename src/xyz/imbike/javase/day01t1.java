package xyz.imbike.javase;

public class day01t1 {
    public static void main(String[] args) {
        // multiplication table
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + " * " + j + " = " + i * j + "\t");
//            }
//            System.out.println();
//        }
        // prime of range 100
        // tip1;
        double startTime = System.currentTimeMillis();
        boolean isPrime = true;

        for (int i = 2; i < 101; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true){
                System.out.print(i + "\t");
            }
            isPrime = true;
        }
        //tip2:

//        System.out.print("2  3  5  7  ");
//        for (int i =11;i<101;i++){
//            if (i%2 != 0 && i%3 !=0&&i%5 !=0&&i%7!=0){
//                System.out.print(i + "\t");
//            }
//        }
        double endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println(endTime-startTime);
    }
}
