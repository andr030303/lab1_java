public class Complex_num {
    
    private double real;
    private double imag;

    public Complex_num(double real, double imag) {

        this.real = real;
        this.imag = imag;

    }

    public void print_num() {
        System.out.printf("%f + %fi", real, imag);
    }

    public Complex_num summ_nums(Complex_num other) {

        double new_real = this.real + other.real;
        double new_imag = this.imag + other.imag;
        return new Complex_num(new_real, new_imag);

    }
    
}
