import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class reinas {
    public static void main(String[] args) {
        int [] sol = ReinasP(8);
        for (int i: sol) {
            System.out.print(i + "\t");
        }
    }

    public static int[] ReinasP(int N) {
        ArrayList<Integer> col=new ArrayList<>();
        ArrayList<Integer> diag45=new ArrayList<>();
        ArrayList<Integer> diag135=new ArrayList<>();
        //ArrayList<Integer>solucion = new ArrayList<>();

        //int[]col = new int[N];
        //int[]diag45 = new int[N];
        //int[]diag135 = new int[N];
        int[]solucion = new int[N];

        int cont = 0;


        int fila = 0;


        //int[]libres = new int[N];
        ArrayList<Integer> libres = new ArrayList<>();
        do {
            int columna = 0;
            libres = new ArrayList<>();

            for (columna = 1; columna <= N ; columna++) {
                if (!col.contains(columna) && !diag45.contains(fila-columna) && !diag135.contains(fila+columna)) {
                    libres.add(columna);
                }
                /*if (!Arrays.asList(col).contains(columna) &&
                        !Arrays.asList(diag45).contains(fila-columna) &&
                        Arrays.asList(diag135).contains(fila+columna)) {
                    libres.add(columna);
                    cont++;
                }*/
            }

            if (!libres.isEmpty()) {
                columna = elementoAleatorio(libres);
                //solucion.add(solucion.get(fila), columna);
                solucion[fila] = columna;
                col.add(columna);
                diag45.add(fila-columna);
                diag135.add(fila+columna);
                fila++;
            }

        }while (fila < N && !libres.isEmpty());
        if (libres.isEmpty()) {
            return null;
        }else {
            return solucion;
        }
    }

    private static int elementoAleatorio(ArrayList<Integer> libres) {
        Random rand = new Random();
        return libres.get(rand.nextInt(libres.size()));
    }
}
