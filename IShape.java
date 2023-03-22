import java.util.Scanner;

public interface IShape {
    public void define();
    public String[] draw();
    public char getposition(int X, int Y);
    public String[] setborder();
}
