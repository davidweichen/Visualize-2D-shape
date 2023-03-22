import java.util.Scanner;

public class triangle implements IShape{
    private int height;
    private int Xcoordinate, Ycoordinate;
    private String[] rows;

    public void define(){

        System.out.println("enter height");
        Scanner scanner3 = new Scanner(System.in);
        height = scanner3.nextInt();
        System.out.println("enter Xcoordinate");
        Scanner scanner = new Scanner(System.in);
        Xcoordinate = scanner.nextInt();
        System.out.println("enter Ycoordinate");
        Scanner scanner1 = new Scanner(System.in);
        Ycoordinate = scanner1.nextInt();
    }
    public String[] draw(){
        rows = new String[height];
        for(int i=0;i< rows.length;i++){
            rows[i] = " ";
        }
        for(int i=height-1;i>=0;i--){
            for(int j=height-1;j>i;j--){
                rows[i]+=" ";
            }
            for(int j=0;j<2*i+1;j++){
                rows[i]+="*";
            }
            for(int j=height-1;j>i;j--){
                rows[i]+=" ";
            }
        }
        return rows;
    }
    public String[] setborder(){
        for(int k=0;k<= rows.length-2;k++) {
            char[] r = rows[k].toCharArray();
            for (int i = 1+k; i < rows.length - 1; i++) {
                char[] r1 = rows[i].toCharArray();
                for (int j = 0; j < rows[i].length(); j++) {
                    if (r1[j] == r[j]) {
                        r1[j] = ' ';
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
