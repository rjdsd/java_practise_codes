import java.lang.Double;
/* 
Overflowing value : when n = 2^31 = 2147483648
*/
class CalculatePower {
    public double myPow(double x, int n) {
        boolean overflow_risk = false;
        boolean neg_power = false;
        double product, temp = 0.0;
        if(x == 0){
            return Double.POSITIVE_INFINITY;
        }
        // 2^31
        if(n == -2147483648){
            overflow_risk = true; 
        }
        if(n < 0){
            neg_power = true;
            n = n * (-1);
        }
        System.out.println(n);
        if(overflow_risk && neg_power){
            n--;
        }
        if(n == 0) {
            return 1;
        } 
        else if (n % 2 == 0) {
            temp = myPow(x, n/2);
            product =  temp * temp;
        } 
        else {
            temp = myPow(x, (n-1)/2);
            product = x * temp * temp;
        }
        if(overflow_risk){
            product = product * x;
        }
        if(neg_power){
            product = 1/product;
        }
        return product;
    }
}