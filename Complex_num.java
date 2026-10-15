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


    public double getRe() {
        return real;
    }

    public double getIm() {
        return imag;
    }

    public Complex_num summ_nums(Complex_num other) {

        double new_real = this.real + other.real;
        double new_imag = this.imag + other.imag;
        return new Complex_num(new_real, new_imag);

    }
    
    public Complex_num multiplication(Complex_num other) {
        double new_real = this.real * other.real - this.imag * other.imag;
        double new_imag = this.real * other.imag + this.imag * other.real;
        return new Complex_num(new_real, new_imag); 
    }

    public Complex_num division(Complex_num other) {
        double new_real = (this.real * other.real + this.imag * other.imag) / (Math.pow(other.real, 2) + Math.pow(other.imag, 2));
        double new_imag = (this.imag * other.real - this.real * other.imag) / (Math.pow(other.real, 2) + Math.pow(other.imag, 2));
        return new Complex_num(new_real, new_imag); 
    }

}
