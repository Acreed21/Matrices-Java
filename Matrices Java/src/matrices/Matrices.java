package matrices;

/**
 *
 * @author Cristhian
 */
public class Matrices {

    public static void main(String args[]) {
        double Tiempo2 = 0, Tiempo1 = 0, TiempoTotal = 0, t = 0;
        double[] promedio = new double[10];
        int elementos;
        for (int i = 10; i <= 100; i++) {
            int tamanno = i;
            int[][] matrizuno = new int[tamanno][tamanno];
            int[][] matrizdos = new int[tamanno][tamanno];
            for (int j = 0; j < tamanno; j++) {
                for (int k = 0; k < tamanno; k++) {
                    matrizuno[j][k] = 1;
                    matrizdos[j][k] = 2;
                }
            }
            int[][] matriztres = new int[tamanno][tamanno];
            for (int h = 0; h < 10; h++) {
                Tiempo1 = System.nanoTime();
                for (int j = 0; j < tamanno; j++) {
                    for (int k = 0; k < tamanno; k++) {
                        matriztres[j][k] = 0;
                        for (int f = 0; f < tamanno; f++) {
                            matriztres[j][k] += matrizdos[j][f] * matrizuno[f][k];
                        }
                    }
                }
                Tiempo2 = System.nanoTime();
                TiempoTotal = ((Tiempo2 - Tiempo1) / 1e9);
                elementos = tamanno * tamanno;
                t = TiempoTotal / ((tamanno * elementos) + (tamanno - 1) * elementos);
                int posicion = (i - 10)/10;
                promedio[posicion] += t;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(promedio[i]/10);
        }
    }
}
