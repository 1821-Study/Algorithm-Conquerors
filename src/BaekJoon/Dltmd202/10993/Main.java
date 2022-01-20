import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int N;
    private static final Scanner sc = new Scanner(System.in);
    private static List<Integer> gridWidths;
    private static List<Integer> gridHeights;
    private static char[][] map;

    private static int gridWidth = 1;
    private static int gridHeight = 1;

    public static void main(String[] args) {
        gridHeights = new ArrayList<>();
        gridWidths = new ArrayList<>();

        N = sc.nextInt();

        gridWidth = 1;
        gridHeight = 1;
        gridHeights.add(0);
        gridWidths.add(0);
        gridHeights.add(gridHeight);
        gridWidths.add(gridWidth);

        for(int i = 1; i <= N; i ++){
            gridHeight = gridHeight * 2 + 1;
            gridWidth = gridWidth * 2 + 3;

            gridHeights.add(gridHeight);
            gridWidths.add(gridWidth);
        }

        map = new char[gridHeights.get(gridHeights.size() - 1)][gridWidths.get(gridWidths.size() - 1)];
        makeMap(0, 0, N);
        printMap();
    }


    public static void makeMap(int y, int x, int step){
        if(step > 0){
            int hgrid = gridHeights.get(step);
            int wgrid = gridWidths.get(step);
            if(step % 2 == 0){
                for(int j = 0; j < wgrid; j ++){
                    map[y][x + j] = '*';
                }
                for(int j = 0; j < wgrid / 2 + 1; j ++){
                    map[y + j][x + j] = '*';
                    map[y + j][x + wgrid - 1 - j] = '*';
                }
                makeMap(y + 1, x + gridHeights.get(step) / 2 + 1, step - 1);
            } else {
                int bottom = y + hgrid - 1;
                for(int j = 0; j < wgrid; j ++){
                    map[bottom][x + j] = '*';
                }
                for(int j = 0; j < wgrid / 2 + 1; j ++){
                    map[bottom - j][x + j] = '*';
                    map[bottom - j][x + wgrid - 1 - j] = '*';
                }
                makeMap(y + gridHeights.get(step) / 2, x + gridHeights.get(step) / 2 + 1, step - 1);
            }
        }
    }

    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < gridHeight; i ++){
            for(int j = gridWidth - 1; j >= 0; j --){
                if(map[i][j] != '*') continue;
                else{
                    for(int k = 0; k <= j; k ++){
                        sb.append(map[i][k] == '*'? "*": " ");
                    }
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
