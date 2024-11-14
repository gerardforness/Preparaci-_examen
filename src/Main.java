import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeticions = sc.nextInt();
        boolean[] resultado = new boolean[repeticions];

        for (int i = 0; i < repeticions; i++) {
            int[][] sudoku = new int[9][9];

            // Llenamos el Sudoku
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    sudoku[j][k] = sc.nextInt();
                }
            }

            // Validamos cada fila
            boolean[] filavalida = new boolean[9];
            for (int j = 0; j < 9; j++) {
                boolean[] aparecido = new boolean[9]; // Para verificar los números 1 a 9
                boolean esValida = true;

                for (int k = 0; k < 9; k++) {
                    int num = sudoku[j][k];
                    if (num < 1 || num > 9 || aparecido[num - 1]) {
                        esValida = false;
                        break;
                    }
                    aparecido[num - 1] = true;
                }
                filavalida[j] = esValida;
            }

            // Comprobamos si todas las filas son válidas
            boolean toteslesfilesvalides = true;
            for (int j = 0; j < 9; j++) {
                if (!filavalida[j]) {
                    toteslesfilesvalides = false;
                    break;
                }
            }

            // Si todas las filas son válidas, comprobamos las columnas
            if (toteslesfilesvalides) {
                boolean toteslescolumnesvalides = true;

                for (int j = 0; j < 9; j++) {
                    boolean[] aparecido = new boolean[9];
                    boolean columnaValida = true;

                    for (int k = 0; k < 9; k++) {
                        int num = sudoku[k][j];
                        if (num < 1 || num > 9 || aparecido[num - 1]) {
                            columnaValida = false;
                            break;
                        }
                        aparecido[num - 1] = true;
                    }

                    if (!columnaValida) {
                        toteslescolumnesvalides = false;
                        break;
                    }
                }

                if (toteslescolumnesvalides) {
                    resultado[i] = true;
                }
            }
        }

        for (int i = 0; i < repeticions; i++) {
            System.out.println(resultado[i]);
        }
    }
}
