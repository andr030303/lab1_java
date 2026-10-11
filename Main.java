public class Main {
    public static void main(String[] args) {
    
        Complex_num num1 = new Complex_num(1, 2);
        Complex_num num2 = new Complex_num(4, 2);
        Complex_num num3 = new Complex_num(1.5, 6);
        Complex_num num4 = new Complex_num(1.6, 9);
        Complex_num num5 = new Complex_num(5, 7.1);
        Complex_num num6 = new Complex_num(4.2, 5);
        Complex_num num7 = new Complex_num(4.1, 2.5);
        Complex_num num8 = new Complex_num(1.1, 2.8);


        Complex_num nums_1[] = {num1, num2, num3, num4};
        Complex_num nums_2[] = {num5, num6, num7, num8};


        Matrix complex_1 = new Matrix(nums_1, 2, 2);
        Matrix complex_2 = new Matrix(nums_2, 2, 2);
        complex_1.print_matrix();


        Matrix complex_3 = complex_2.summ_complex(complex_1);
        complex_3.print_matrix();


    }
}