public class Matrix {

    private Complex_num[] nums;
    private int hight, wide;

    public Matrix(Complex_num[] nums, int hight, int wide) {
        this.nums = nums;
        this.hight = hight;
        this.wide = wide; 
    }

    public void print_matrix() {
        for (int y = 0; y < hight; y++) {
            System.out.printf("|");
            for (int x = 0; x < wide; x++) {
                nums[wide * y + x].print_num();
                System.out.printf("|");

            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    public Complex_num[] getNumbers() {
        return nums;
    }

    public Matrix summ_complex(Matrix other) {
        Complex_num[] new_nums = new Complex_num[hight * wide];
        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < wide; x++) {
                new_nums[wide * y + x] = nums[wide * y + x].summ_nums(other.getNumbers()[wide * y + x]);
            }
        }
        return new Matrix(new_nums, hight, wide);
    }


}
