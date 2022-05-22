package xyz.imbike.datastructure;

public class SparseArray {
    public static void main(String[] args) {
        // 1:black 2:blue
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        System.out.println("原始的二维数组：");

        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //二维数组转换为稀疏数组
        // 1.遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.稀疏数组创立及稀疏数组的赋值
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        //输出稀疏数组；
        System.out.println("稀疏数组为；");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("恢复的二维数组：");

        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
