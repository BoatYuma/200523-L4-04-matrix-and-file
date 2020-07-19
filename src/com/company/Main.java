package com.company;

import java.io.*;

public class Main {

    private static final String MATRIX_1_PARSING_COMMENT = "Double number for matrix 1 at ";
    private static final String MATRIX_2_PARSING_COMMENT = "Double number for matrix 2 at ";

    public static void main(String[] args) {
        // write your code here

        try {
            BufferedReader in_stream_char =
                    new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Dimension N:");
            int dimensionN = Integer.parseInt(in_stream_char.readLine());
            System.out.print("dimension M:");
            int dimensionM = Integer.parseInt(in_stream_char.readLine());
            System.out.print("dimension P:");
            int dimensionP = Integer.parseInt(in_stream_char.readLine());

            Double[][] matrix1 = new Double[dimensionN][dimensionM];
            Double[][] matrix2 = new Double[dimensionM][dimensionP];

            parseMatrix(in_stream_char, dimensionN, dimensionM, matrix1, MATRIX_1_PARSING_COMMENT);
            parseMatrix(in_stream_char, dimensionM, dimensionP, matrix2, MATRIX_2_PARSING_COMMENT);

            Double[][] matrix3 = new Double[dimensionN][dimensionP];
            for (int i = 0; i < dimensionN; i++)
                for (int j = 0; j < dimensionP; j++) {
                    matrix3[i][j] = 0.0;
                    for (int k = 0; k < dimensionM; k++)
                        matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];

                }
            PrintStream out_stream = new PrintStream(
                    new FileOutputStream("resources/out.txt"));

            for (int i = 0; i < dimensionN; i++) {
                for (int j = 0; j < dimensionP; j++)
                    out_stream.print(matrix3[i][j] + " ");
                out_stream.println();
            }
            out_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void parseMatrix(BufferedReader in_stream_char, int dimensionN, int dimensionM, Double[][] matrix1, String s) throws IOException {
        for (int i = 0; i < dimensionN; i++)
            for (int j = 0; j < dimensionM; j++) {
                System.out.print(s + i + j + ":");
                matrix1[i][j] = Double.parseDouble(in_stream_char.readLine());
            }
    }
}
