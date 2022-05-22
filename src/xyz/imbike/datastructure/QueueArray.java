package xyz.imbike.datastructure;

import java.util.Scanner;

public class QueueArray {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show):显示对列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队头取出数据");
            System.out.println("h(head):查看队头数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("当前队头数据是：%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
            }
        }
        System.out.println("程序退出~~");

    }
}

//使用数组模拟队列
class ArrayQueue {
    private int maxSize;
    private int front; //队列头的前一个位置
    private int rear; //队尾位置
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，指向队列头的前一个位置
        rear = -1; //指向队尾，指向队列尾部的具体位置，即就是队尾的数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //isFull
        if (isFull()) {
            System.out.println("队列已满，暂时无法加入数据~~~");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;
    }

    //出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~~");
        }
        return arr[front + 1];
    }

}
