import java.util.Scanner;

public class Main {



    private static Scanner scanner = new Scanner(System.in);

    private static Complex_num[] fill_matrix(int wide, int height) {

        Complex_num[] matrix = new Complex_num[wide * height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < wide; j++) {
                    System.out.println("Позиция " + "(" + j + "," + i + ")" +  ":");
                    System.out.println("Действительная часть: ");
                    double real = scanner.nextDouble();
                    System.out.println("Мнимая часть: ");
                    double imag = scanner.nextDouble();
                    matrix[i * j + j] = new Complex_num(real, imag);
                }
            }
        return matrix;
    }


    public static void main(String[] args) {

    
        // Complex_num num1 = new Complex_num(1, 2);
        // Complex_num num2 = new Complex_num(4, 2);
        // Complex_num num3 = new Complex_num(1.5, 6);
        // Complex_num num4 = new Complex_num(1.6, 9);
        // Complex_num num5 = new Complex_num(5, 7.1);
        // Complex_num num6 = new Complex_num(4.2, 5);
        // Complex_num num7 = new Complex_num(4.1, 2.5);
        // Complex_num num8 = new Complex_num(1.1, 2.8);


        // Complex_num nums_1[] = {num1, num2, num3, num4};
        // Complex_num nums_2[] = {num5, num6, num7, num8};


        // Matrix complex_1 = new Matrix(nums_1, 2, 2);
        // Matrix complex_2 = new Matrix(nums_2, 2, 2);
        // complex_1.print_matrix();


        // Matrix complex_3 = complex_2.multiplication_complex(complex_1);
        // complex_3.print_matrix();

        // Complex_num det_1 = complex_3.determinant();
        // det_1.print_num();


        // Matrix complex_4 = complex_2.division(complex_1);
        // complex_4.print_matrix();


        // Matrix complex_5 = complex_2.transpose();
        // complex_5.print_matrix();

        System.out.println();
        System.out.printf("1 - Создать матрицу");
        System.out.println();
        System.out.printf("0 - Выход");
        System.out.println();
        int inp_1 = scanner.nextInt();
        if (inp_1 == 1) {
            boolean RUN = true;
            System.out.printf("Введите размер матрицы");
            System.out.println();
            System.out.printf("Ширина: ");
            int wide = scanner.nextInt();
            System.out.printf("Высота: ");
            int height = scanner.nextInt();
            Complex_num[] matrix = fill_matrix(wide, height);
            Matrix complex_1 = new Matrix(matrix, wide, height);
            complex_1.print_matrix();
            while (RUN == true) {
                    System.out.printf("1 - Сложение матриц%n");
                    System.out.printf("2 - Умножение матриц%n");
                    System.out.printf("3 - Деление матриц%n");
                    System.out.printf("4 - Транспонирование матриц%n");
                    System.out.printf("5 - Определитель матрицы%n");
                    System.out.printf("6 - Вывести матрицу%n");
                    System.out.printf("0 - Выход%n");
                    int inp_2 = scanner.nextInt();
                    if (inp_2 == 1) {
                        System.out.printf("Введите размер матрицы");
                        System.out.println();
                        System.out.printf("Ширина: ");
                        int wide_1 = scanner.nextInt();
                        System.out.printf("Высота: ");
                        int height_1 = scanner.nextInt();
                        Complex_num[] matrix_new = fill_matrix(wide, height);
                        Matrix complex_2 = new Matrix(matrix_new, wide_1, height_1);
                        complex_1 = complex_1.summ_complex(complex_2);
                    }
                    else if (inp_2 == 2) {
                        System.out.printf("Введите размер матрицы");
                        System.out.println();
                        System.out.printf("Ширина: ");
                        int wide_2 = scanner.nextInt();
                        System.out.printf("Высота: ");
                        int height_2 = scanner.nextInt();
                        Complex_num[] matrix_new = fill_matrix(wide_2, height_2);
                        Matrix complex_2 = new Matrix(matrix_new, wide_2, height_2);
                        complex_1 = complex_1.multiplication_complex(complex_2);
                    }
                    else if (inp_2 == 3) {
                        System.out.printf("Введите размер матрицы");
                        System.out.println();
                        System.out.printf("Ширина: ");
                        int wide_3 = scanner.nextInt();
                        System.out.printf("Высота: ");
                        int height_3 = scanner.nextInt();
                        Complex_num[] matrix_new = fill_matrix(wide_3, height_3);
                        Matrix complex_2 = new Matrix(matrix_new, wide_3, height_3);
                        complex_1 = complex_1.division(complex_2);
                    }
                    else if (inp_2 == 4) {
                        complex_1 = complex_1.transpose();
                    }
                    else if (inp_2 == 5) {
                        System.out.println(complex_1.determinant());
                    }
                    else if (inp_2 == 6) {
                        complex_1.print_matrix();    
                    }
                    else {
                        RUN = false;
                    }
            }
        }

        

    }
}