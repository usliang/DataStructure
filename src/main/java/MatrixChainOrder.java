/****
 * Created by liliang on 6/13/17.
 * We state the matrix-chain multiplication problem as follows: given
 * a chain A1;A2;:::;An of n matrices,where for i = 1;2;:::;n,matrix Ai has dimension
 * pi-1  pi,fully parenthesize the product A1 A2   An in away that minimizes the
 * number of scalar multiplications.
 ****/

public class MatrixChainOrder {

    public static void bottomUpFindOptimalSolution(int[] p, int[][] cost, int[][]orders){
        int n = p.length - 1;

        for (int i = 1; i <= n; i++){
            cost[i] [i] =0;
        }

        for (int l = 2; l <= n; l++){
            for (int i = 1; i <= n-l+1; i++){
                int j = i+l-1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j-1 ; k++){
                    int tempCost = cost[i][k] + cost[k+1][j] + p[i-1 ] * p[k] * p[j];
                    if (tempCost < cost[i][j]){
                        cost[i][j] = tempCost;
                        orders[i][j] = k;
                    }
                }
            }
        }
    }

    // Print out the optimal parenthesization of matrices
    public static void printSolution(int[][] solutions,int i,int j){
        if(i==j){
            System.out.print("A"+i);
        }else{
            System.out.print("(");
            printSolution(solutions, i, solutions[i][j]);
            printSolution(solutions, solutions[i][j]+1, j);
            System.out.print(")");
        }
    }

    static class Matrix {
        public int rows = 0;
        public int columns = 0;
        public int[][] data = null;

        public Matrix(int rows, int columns) {
            this.rows = rows;

            this.columns = columns;
            data = new int[rows][columns];

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    data[i][j] = 0;
                }
            }
        }
    }

    public static Matrix matrixMultiply(Matrix a, Matrix b){
        if (a.columns != b.rows){
            throw new IllegalArgumentException("Matrix A's column must equal to Matrix B's row");
        }
        Matrix c = new Matrix(a.rows, b.columns);
        for (int i = 0; i < a.rows; i ++){
            for (int j = 0; j < b.columns; j++){
                for (int k = 0; k  < a.columns; k++){
                    c.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        return c;
    }
}
