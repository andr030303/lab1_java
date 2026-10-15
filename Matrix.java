public class Matrix {

    private Complex_num[] nums;
    private int hight, wide;

    public Matrix(Complex_num[] nums, int hight, int wide) {
        this.nums = nums;
        this.hight = hight;
        this.wide = wide; 
    }

    public void print_matrix() {
        System.out.println(hight);
        System.out.println(wide);
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
        if (wide != other.wide || hight != other.hight) {
            throw new IllegalArgumentException(
                "Нельзя умножить: ширина первой (" + this.wide +
                ") != высоте второй (" + other.hight + ")"
            );
        }
        Complex_num[] new_nums = new Complex_num[hight * wide];
        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < wide; x++) {
                new_nums[wide * y + x] = nums[wide * y + x].summ_nums(other.getNumbers()[wide * y + x]);
            }
        }
        return new Matrix(new_nums, hight, wide);
    }


    public Matrix multiplication_complex(Matrix other) {
        if (wide != other.hight) {
            throw new IllegalArgumentException(
                "Нельзя умножить: ширина первой (" + wide +
                ") != высоте второй (" + other.hight + ")"
            );
        }

        Complex_num[] new_nums = new Complex_num[hight * other.wide];

        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < other.wide; x++) {
                Complex_num sum = new Complex_num(0, 0);

                for (int k = 0; k < wide; k++) {
                    Complex_num a = nums[this.wide * y + k];      
                    Complex_num b = other.nums[other.wide * k + x];    
                    sum = sum.summ_nums(a.multiplication(b));
                }

                new_nums[other.wide * y + x] = sum;
            }
        }

        return new Matrix(new_nums, this.hight, other.wide);
    }

    public Complex_num determinant() {
        if (this.hight != this.wide) {
            throw new IllegalArgumentException("Определитель только для квадратных матриц");
        }
        return det(this.nums, this.hight);
    }

    private Complex_num det(Complex_num[] m, int n) {
        if (n == 1) {
            return m[0];
        }
        if (n == 2) {
            Complex_num ac = m[0].multiplication(m[3]);
            Complex_num bd = m[1].multiplication(m[2]);
            return ac.summ_nums(bd.multiplication(new Complex_num(-1, 0)));
        }

        Complex_num result = new Complex_num(0, 0);

        for (int j = 0; j < n; j++) {
            Complex_num[] minor = new Complex_num[(n - 1) * (n - 1)];
            int idx = 0;
            for (int row = 1; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (col == j) continue;
                    minor[idx++] = m[n * row + col];
                }
            }

            Complex_num term = m[j].multiplication(det(minor, n - 1));

            if (j % 2 == 1) {
                term = term.multiplication(new Complex_num(-1, 0));
            }

            result = result.summ_nums(term);
        }

        return result;
    }


    private Matrix inverse() {
        if (hight != wide) {
            throw new IllegalArgumentException("Обратная только для квадратных матриц");
        }
        int n = hight;

        Complex_num[] aug = new Complex_num[n * 2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[2 * n * i + j] = nums[n * i + j];
                aug[2 * n * i + (n + j)] = (i == j)
                    ? new Complex_num(1, 0)
                    : new Complex_num(0, 0);
            }
        }

        for (int col = 0; col < n; col++) {
            int pivot = -1;
            for (int row = col; row < n; row++) {
                if (!isZero(aug[2 * n * row + col])) {
                    pivot = row;
                    break;
                }
            }
            if (pivot == -1) {
                throw new ArithmeticException("Матрица вырождена, обратной не существует");
            }

            if (pivot != col) {
                for (int j = 0; j < 2 * n; j++) {
                    Complex_num tmp = aug[2 * n * col + j];
                    aug[2 * n * col + j] = aug[2 * n * pivot + j];
                    aug[2 * n * pivot + j] = tmp;
                }
            }

            Complex_num lead = aug[2 * n * col + col];
            for (int j = 0; j < 2 * n; j++) {
                aug[2 * n * col + j] = aug[2 * n * col + j].division(lead);
            }

            for (int row = 0; row < n; row++) {
                if (row == col) continue;
                Complex_num factor = aug[2 * n * row + col];
                if (isZero(factor)) continue;
                for (int j = 0; j < 2 * n; j++) {
                    Complex_num sub = factor.multiplication(aug[2 * n * col + j]);
                    aug[2 * n * row + j] = aug[2 * n * row + j].summ_nums(
                        sub.multiplication(new Complex_num(-1, 0))
                    );
                }
            }
        }

        Complex_num[] inv = new Complex_num[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[n * i + j] = aug[2 * n * i + (n + j)];
            }
        }
        return new Matrix(inv, n, n);
    }

    private boolean isZero(Complex_num z) {
        return Math.abs(z.getRe()) < 1e-12 && Math.abs(z.getIm()) < 1e-12;
    }

    public Matrix division(Matrix other) {
        return this.multiplication_complex(other.inverse());
    }

    public Matrix divisionLeft(Matrix other) {
        return other.inverse().multiplication_complex(this);
    }


    public Matrix transpose() {
        Complex_num[] new_nums = new Complex_num[wide * hight]; 

        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < wide; x++) {
                new_nums[hight * x + y] = nums[wide * y + x];
            }
        }

        return new Matrix(new_nums, wide, hight);  
    }



}
