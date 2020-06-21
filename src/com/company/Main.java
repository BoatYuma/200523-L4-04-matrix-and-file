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
            int dimentionN = Integer.parseInt(in_stream_char.readLine());
            System.out.print("Dimention M:");
            int dimentionM = Integer.parseInt(in_stream_char.readLine());
            System.out.print("Dimention P:");
            int dimentionP = Integer.parseInt(in_stream_char.readLine());

            Double[][] matrix1 = new Double[dimentionN][dimentionM];
            Double[][] matrix2 = new Double[dimentionM][dimentionP];

            parseMatrix(in_stream_char, dimentionN, dimentionM, matrix1, MATRIX_1_PARSING_COMMENT);
            parseMatrix(in_stream_char, dimentionM, dimentionP, matrix2, MATRIX_2_PARSING_COMMENT);

            Double[][] matrix3 = new Double[dimentionN][dimentionP];
            for (int i = 0; i < dimentionN; i++)
                for (int j = 0; j < dimentionP; j++) {
                    matrix3[i][j] = 0.0;
                    for (int k = 0; k < dimentionM; k++)
                        matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];

                }
            PrintStream out_stream = new PrintStream(
                    new FileOutputStream("resources/out.txt"));

            for (int i = 0; i < dimentionN; i++) {
                for (int j = 0; j < dimentionP; j++)
                    out_stream.print(matrix3[i][j] + " ");
                out_stream.println();
            }
            out_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void parseMatrix(BufferedReader in_stream_char, int dimentionN, int dimentionM, Double[][] matrix1, String s) throws IOException {
        for (int i = 0; i < dimentionN; i++)
            for (int j = 0; j < dimentionM; j++) {
                System.out.print(s + i + j + ":");
                matrix1[i][j] = Double.parseDouble(in_stream_char.readLine());
            }
    }
}
