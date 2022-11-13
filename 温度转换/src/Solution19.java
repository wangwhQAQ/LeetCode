import java.math.BigDecimal;

public class Solution19 {
    public double[] convertTemperature(double celsius) {
        double c1 = (double) Math.round((celsius + 273.15000) *100000)/100000;
        double c2 = (double) Math.round((celsius * 1.80000 +32.00000) *100000)/100000;
        String str = String.format("%.5f",c1);
        double cc1 = Double.parseDouble(str);

        String str2 = String.format("%.5f",c2);
        double cc2 = Double.parseDouble(str2);

        return new double[]{cc1,cc2};
    }

    public static void main(String[] args) {
        Solution19 s = new Solution19();
        s.convertTemperature(37.10000);
    }
}
