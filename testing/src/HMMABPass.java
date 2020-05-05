import java.io.IOException;
import java.util.Arrays;


public class HMMABPass {

    public static void main(String[] args) throws IOException {


        int N = 2; //number of states
        int M = 3; //number of observation symbols (count of possible observations to chose from)
        double[][] A = new double[N][N]; //transition matrix
        double[][] B = new double[N][M]; //observation matrix
        double[] pi = new double[N]; //initial state distribution
        int[] O = new int[]{0,1,0,2}; //observation sequence
        int T = O.length; //number of observations in observation sequence

        // fill out a data
        A[0][0] = 0.7; A[0][1] = 0.3;
        A[1][0] = 0.4; A[1][1] = 0.6;

        // fill out b data
        B[0][0] = 0.1; B[0][1] = 0.4; B[0][2] = 0.5;
        B[1][0] = 0.7; B[1][1] = 0.2; B[1][2] = 0.1;

        // fill out pi data
        pi[0] = 0.6; pi[1] = 0.4;


        HMMABPass hmm = new HMMABPass();
        System.out.println("\n Alpha pass is: " +  Arrays.deepToString(hmm.alpha_pass(O, A, B, pi, T, N)));
        System.out.println(" Beta pass is: " + Arrays.deepToString(hmm.beta_pass(O, A, B, pi, T, N)));
    }



    /**
     *         Alpha Pass
     *         int N ; //number of states
     *         int M ; //number of observation symbols (count of possible observations to chose from)
     *         double[][] A = new double[N][N]; //transition matrix
     *         double[][] B = new double[N][M]; //observation matrix
     *         double[] pi = new double[N]; //initial state distribution
     *         int[] O = new int[]{.......}; //observation sequence
     *         int T = O.length; //number of observations in observation sequence
     */
    public double[][] alpha_pass(int[] O, double[][] a, double[][] b, double[] pi, int T, int N)
    {

        double[][] alpha_array = new double[N][T]; //initialize alpha

        for(int i = 0; i < N; i++) {
            alpha_array[i][0] = pi[i] * b[i][O[0]];
        }

        for (int t = 1; t < T; t++) {
            for(int n = 0; n < N; n++) {
                for(int i = 0; i < N; i++) {
                    alpha_array[n][t] += (alpha_array[i][t - 1] * a[i][n]);
                }
                alpha_array[n][t] *= b[n][O[t]];
            }
        }

        return alpha_array;
    }



    /**
     *         Beta Pass
     *         int N ; //number of states
     *         int M ; //number of observation symbols (count of possible observations to chose from)
     *         double[][] A = new double[N][N]; //transition matrix
     *         double[][] B = new double[N][M]; //observation matrix
     *         double[] pi = new double[N]; //initial state distribution
     *         int[] O = new int[]{.......}; //observation sequence
     *         int T = O.length; //number of observations in observation sequence
     */
    public double[][] beta_pass(int[] O, double[][] a, double[][] b, double[] pi,int T, int N)
    {

        double[][] beta_array = new double[N][T]; //initialize beta


        for(int i = 0; i < N; i++) {
            beta_array[i][T-1] = 1;
        }
//
//        // Loop through all rows
//        for (int i = 0; i < beta.length; i++)
////             Loop through all elements of current row
//            for (int j = 0; j < beta[i].length; j++)
//                System.out.print(beta[i][j] + " ");

        for (int t = T-2; t >= 0; t--) {
            for(int n = 0; n < N; n++) {
                for(int i = 0; i < N; i++) {
                    beta_array[n][t] += ( a[n][i] * beta_array[i][t+1] * b[i][O[t+1]]);
                }
            }
        }


        return beta_array;
    }






}