import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int height;
    private static int width = 5;
    private static int step;
    private static char[][] map;
    private static ArrayList<Integer> widthGrid;
    private static ArrayList<Integer> heightGrid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        widthGrid = new ArrayList<>();
        heightGrid = new ArrayList<>();

        height = sc.nextInt();
        widthGrid.add(width);

        int heightCalculator = 3;
        heightGrid.add(heightCalculator);

        for(int i = 3; i < height; i *= 2){
            step ++;
            width = width * 2 + 1;
            widthGrid.add(width);
            heightCalculator *= 2;
            heightGrid.add(heightCalculator);
        }

        map = new char[height][width];
        makeMap(height - 1, width - 1, step);

        printMap();
    }

    public static void makeMap(int y, int x, int step){
        if(step == 0){
            for(int j = x; j > x - 5; j --){
                map[y][j] = '*';
            }
            map[y - 1][x - 1] = '*';
            map[y - 2][x - 2] = '*';
            map[y - 1][x - 3] = '*';
        } else {
            makeMap(y, x, step - 1);
            makeMap(y - heightGrid.get(step - 1), x - widthGrid.get(step - 1) / 2 - 1, step - 1);
            makeMap(y, x - widthGrid.get(step - 1) - 1, step - 1);
        }
    }

    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j ++){
                sb.append(map[i][j] == '*'? "*": " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
