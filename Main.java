import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    Deque<IShape> Shape = new LinkedList<IShape>();

    public static void main(String[] args) {
        int e;
        screenbuffer buffer = new screenbuffer(30,30);
        System.out.println("1.circle 2.triangle 3.rectangle 4.exit");
        Scanner scanner = new Scanner(System.in);
        e = scanner.nextInt();
        while(e!=4){
            if(e==1){
                IShape obj = new circle();
                obj.define();
                obj.draw();
                buffer.addShape(obj);
            } else if (e==2) {
                IShape obj = new triangle();
                obj.define();
                obj.draw();
                buffer.addShape(obj);
            } else if (e==3) {
                IShape obj = new rectangle();
                obj.define();
                obj.draw();
                buffer.addShape(obj);
            }
            System.out.println("1.circle 2.triangle 3.rectangle 4.exit");
            Scanner scanner1 = new Scanner(System.in);
            e = scanner1.nextInt();
        }


        buffer.setShape();
        buffer.display();

    }



}