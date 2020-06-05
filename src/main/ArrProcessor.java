package main;

public class ArrProcessor
        implements ArrayProcessor{
    @Override
    public double calculate(double[] array) {
        double min = -0.0, max = -0.0;
        for (double v : array) {
            if (v >= 0) {
                min = v;
                break;
            }
        }
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] >= 0) {
                max = array[i];
                break;
            }
        }
        return min - max;
    }

    @Override
    public double calculate(double[][] array) {
        double min = -0.0, max = -0.0;
        for (int i = 0; i < array.length; i++) {
            if (array[0][i] >= 0) {
                min = array[0][i];
                break;
            }
        }
        for (int i = array.length-1; i >= 0; i--) {
            if (array[array.length-1][i] >= 0) {
                max = array[array.length-1][i];
                break;
            }
        }
        return min - max;
    }

    @Override
    public void processArray(double[] array) {
        double[][] arr = arrayTwoDFromOneD(array);
        StringBuilder str = new StringBuilder();
        int nn = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length/2) {
                nn++;
            } else if (i != arr.length/2) {
                nn--;
            }
            int f = nn, l = arr.length-nn;
            for (int j = 0; j < arr.length; j++) {
                if (f <= j && j < l) {
                    String buff = String.valueOf(arr[i][j]);
                    if (buff.length() == 2) {
                        str.append("    ");
                    } else if (buff.length() == 3) {
                        str.append("   ");
                    } else if (buff.length() == 4) {
                        str.append("  ");
                    } else if (buff.length() == 5) {
                        str.append(" ");
                    }
                    str.append(" ").append(arr[i][j]);
                }
                else str.append(" ----.-");
            }
            System.out.println(str);
            str.delete(0,str.length());
        }
    }

    @Override
    public void processArray(double[][] array) {
        StringBuilder str = new StringBuilder();
        int nn = -1;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length/2) {
                nn++;
            } else if (i != array.length/2) {
                nn--;
            }
            int f = nn, l = array.length-nn;
            for (int j = 0; j < array.length; j++) {
                if (f <= j && j < l) {
                    String buff = String.valueOf(array[i][j]);
                    if (buff.length() == 2) {
                        str.append("    ");
                    } else if (buff.length() == 3) {
                        str.append("   ");
                    } else if (buff.length() == 4) {
                        str.append("  ");
                    } else if (buff.length() == 5) {
                        str.append(" ");
                    }
                    str.append(" ").append(array[i][j]);
                }
                else str.append(" ----.-");
            }
            System.out.println(str);
            str.delete(0,str.length());
        }
    }

    private double[][] arrayTwoDFromOneD(double[] array) {
        int n = (int)Math.sqrt(array.length);
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = array[i*10+j];
            }
        }
        return arr;
    }
}
