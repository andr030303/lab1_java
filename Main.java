import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Complex_num[] fill_matrix(int wide, int height) {
        Complex_num[] matrix = new Complex_num[wide * height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                System.out.println("Позиция (" + j + "," + i + "):");
                System.out.print("Действительная часть: ");
                double real = scanner.nextDouble();
                System.out.print("Мнимая часть: ");
                double imag = scanner.nextDouble();

                matrix[i * wide + j] = new Complex_num(real, imag);
            }
        }
        return matrix;
    }

    private static int readSize(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) return value;
                System.out.println("Размер должен быть положительным!");
            } else {
                System.out.println("Это не число! Попробуйте снова.");
                scanner.nextLine();
            }
        }
    }

    private static Matrix createMatrix() {
        int wide = readSize("Ширина: ");
        int height = readSize("Высота: ");
        Complex_num[] data = fill_matrix(wide, height);
        return new Matrix(data, height, wide);
    }

    public static void main(String[] args) {
        try {
            System.out.println();
            System.out.println("1 - Создать матрицу");
            System.out.println("0 - Выход");
            System.out.print("> ");

            int inp_1 = scanner.nextInt();

            if (inp_1 == 1) {
                boolean RUN = true;
                Matrix complex_1 = createMatrix();
                complex_1.print_matrix();

                while (RUN) {
                    try {
                        System.out.println("1 - Сложение матриц");
                        System.out.println("2 - Умножение матриц");
                        System.out.println("3 - Деление матриц");
                        System.out.println("4 - Транспонирование матриц");
                        System.out.println("5 - Определитель матрицы");
                        System.out.println("6 - Вывести матрицу");
                        System.out.println("0 - Выход");
                        System.out.print("> ");

                        int inp_2 = scanner.nextInt();

                        switch (inp_2) {
                            case 1 -> {
                                Matrix complex_2 = createMatrix();
                                complex_1 = complex_1.summ_complex(complex_2);
                                System.out.println("Результат:");
                                complex_1.print_matrix();
                            }
                            case 2 -> {
                                Matrix complex_2 = createMatrix();
                                complex_1 = complex_1.multiplication_complex(complex_2);
                                System.out.println("Результат:");
                                complex_1.print_matrix();
                            }
                            case 3 -> {
                                Matrix complex_2 = createMatrix();
                                complex_1 = complex_1.division(complex_2);
                                System.out.println("Результат:");
                                complex_1.print_matrix();
                            }
                            case 4 -> {
                                complex_1 = complex_1.transpose();
                                System.out.println("Результат:");
                                complex_1.print_matrix();
                            }
                            case 5 -> {
                                Complex_num det = complex_1.determinant();
                                System.out.print("Определитель: ");
                                det.print_num();
                                System.out.println();
                            }
                            case 6 -> complex_1.print_matrix();
                            case 0 -> RUN = false;
                            default -> System.out.println("Неизвестная команда");
                        }

                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так!");
                        System.err.println("Отладка: " + e.getClass().getSimpleName()
                                           + ": " + e.getMessage());
                        if (scanner.hasNextLine()) {
                            scanner.nextLine();
                        }
                    }
                }
            } else if (inp_1 == 0) {
                System.out.println("До свидания!");
            } else {
                System.out.println("Неизвестная команда");
            }

        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
            System.err.println("Отладка: " + e.getClass().getSimpleName()
                               + ": " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}