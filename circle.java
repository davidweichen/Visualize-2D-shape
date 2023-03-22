import java.util.Scanner;

public class circle implements IShape{
    private int radius;
    private int Xcoordinate, Ycoordinate;
    private String[] rows;
    public void define(){
        System.out.println("enter radius");
        Scanner scanner = new Scanner(System.in);
        radius = scanner.nextInt();
        System.out.println("enter Xcoordinate");
        Scanner scanner2 = new Scanner(System.in);
        Xcoordinate = scanner2.nextInt();
        System.out.println("enter Ycoordinate");
        Scanner scanner1 = new Scanner(System.in);
        Ycoordinate = scanner1.nextInt();
    }
    public String[] draw(){
        rows = new String[radius];
        for(int i=0;i< rows.length;i++){
            rows[i] = " ";
        }
        for(int i=0;i<(radius-1)/2;i++){
            for(int j=0;j<radius-2*i-1;j++){
                rows[i]+=" ";
            }
            for(int j=0;j<4*(i)+3;j++){
                rows[i]+="*";
            }
            for(int j=0;j<radius-2*i-1;j++){
                rows[i]+=" ";
            }
        }
        for(int i=0;i<radius*2+1;i++){
            rows[(radius-1)/2] +="*";
        }
        for(int i=((radius-1)/2)+1;i<radius;i++){
            for(int j=0;j<2*i+1-radius;j++){
                rows[i]+=" ";
            }
            for(int j=0;j<(radius-i-1)*4+3;j++){
                rows[i]+="*";
            }
            for(int j=0;j<2*i+1-radius;j++){
                rows[i]+=" ";
            }
        }
        return rows;
    }
    public String[] setborder(){
        for(int k=0;k<= (rows.length/2)-1;k++) {
            char[] r = rows[k].toCharArray();
            for (int i = 1+k; i < rows.length - 1-k; i++) {
                char[] r1 = rows[i].toCharArray();
                for (int j = 0; j < rows[i].length(); j++) {
                    if (r1[j] == r[j]) {
                        r1[j] = ' ';
                    }
                }
                for (int j = 0; j < rows[i].length(); j++) {
                    if (r1[j] == '*') {
                        break;
                    } else if (j == rows[i].length()-1) {
                        r1[0] = '*';
                        r1[rows[i].length()-1] = '*';
                    }
                }
                rows[i] = String.valueOf(r1);

            }
        }

        return rows;
    }
    public char getposition(int X, int Y) {
        try {
            return rows[Y - this.Ycoordinate].charAt(X - this.Xcoordinate);
        } catch (Exception e) {
            return ' ';
        }
    }

}
