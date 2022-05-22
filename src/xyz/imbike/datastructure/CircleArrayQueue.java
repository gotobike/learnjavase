package xyz.imbike.datastructure;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        flag = true;
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

class CircleQueue {
    private int maxSize;
    private int front; //指向队列头的那个位置
    private int rear; //指向队尾的最后一个元素的后一个位置
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        front = 0;
//        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //rear必须取模
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~~~");
            return;
        }
        //思路：从front开始遍历
        for (int i = front; i < front + validSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int validSize() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~~");
        }
        return arr[front];
    }


}
