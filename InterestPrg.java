abstract class Interest {
    abstract double calculate();
}

class SimpleInterest extends Interest {
    double p, r, t;

    SimpleInterest(double principal, double rate, double time) {
        this.p = principal;
        this.r = rate;
        this.t = time;
    }

    double calculate() {
        return (p * r * t)/100;
    }

}

class CompoundInterest extends Interest {
    double p, r, t;
    int n;

    CompoundInterest(double principal, double rate, int compoundingPeriodsPerYear, double time) {
        this.p = principal;
        this.r = rate;
        this.n = compoundingPeriodsPerYear;
        this.t = time;
    }

   
    double calculate() {
        return p * Math.pow(1+(r/(n*100)), n*t)-p;
    }
}

public class InterestPrg {
    public static void main(String args[]) {        
        double principal = 25000;
        double simpleInterestRate = 9.25;        
        double compoundInterestRate = 8.5;
        int time = 5;
        int compoundingPeriodsPerYear = 1;

        Interest simple = new SimpleInterest(principal, simpleInterestRate, time);
        System.out.println("Simple Interest: Rs. " + simple.calculate());
        
        Interest compound = new CompoundInterest(principal, compoundInterestRate, compoundingPeriodsPerYear, time);
        System.out.println("Compound Interest: Rs. " + compound.calculate());
    }
}
