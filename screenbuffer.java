import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class screenbuffer {
    private String[] rows;

    private int X;
    private int Y;
    private Deque<IShape> Shape = new LinkedList<IShape>();
    private int f;
    public screenbuffer(int x, int y) {
        X = x;
        Y = y;
        rows = new String[Y];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                rows[i] += " ";
            }
        }
    }

    public void fill(char c) {
        for (int i = 0; i < Y; i++) {
            char[] row = rows[i].toCharArray();

            for (int j = 0; j < X; j++) {
                row[j] = c;
            }

            rows[i] = String.valueOf(row);
        }
    }
    public void setShape(){
        System.out.println("1.full shape 2.only border");
        Scanner scanner = new Scanner(System.in);
        f = scanner.nextInt();
        if(f == 2){
            for(IShape shape: Shape){
                shape.setborder();
            }


        }
    }
    public void clear() {
        fill(' ');
    }
    public void display() {
        display(true);
    }

    public void display(boolean clear){
        if (clear) {
            clear();
        }
        for (IShape shape: Shape) {
            drawShape(shape);
        }

        for (int i = 0; i < Y; i++) {
            System.out.println(rows[i]);
        }
    }
    public void addShape(IShape shape) {
        Shape.add(shape);
    }
    public void drawShape(IShape shape) {
        for (int y = 0; y < Y; y++) {
            char[] row = rows[y].toCharArray();

            for (int x = 0; x < X; x++) {
                char symbol = shape.getposition(x, y);
                if (symbol != ' ') {
                    row[x] = symbol;
                }
            }

            rows[y] = String.valueOf(row);
        }
    }

}
