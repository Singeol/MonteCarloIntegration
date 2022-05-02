import java.util.Scanner;
import java.lang.Math;

public class Main {
    public double monteCarloIntegration(Calculator calculator, double bottomEdge, double topEdge, int stepCount) {
        double Ymin = Double.MAX_VALUE;
        double Ymax = Double.MIN_VALUE;
        for (double i = bottomEdge; i <= topEdge; i++){
            double y = calculator.func(i);
            Ymin = Math.min(Ymin, y);
            Ymax = Math.max(Ymax, y);
        }
        int Nbottom = 0;
        for (int i = 0; i < stepCount; i++){
            double x = bottomEdge + Math.random() * (topEdge - bottomEdge);
            double y = Ymin + Math.random() * (Ymax - Ymin);
            if(y <= Ymin + calculator.func(x)){
                Nbottom++;
            }
        }
        return (topEdge - bottomEdge) * (Ymax - Ymin) * (double) Nbottom / (double) stepCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Main integral = new Main();
        double bottomEdge = scanner.nextDouble();
        double topEdge = scanner.nextDouble();
        int stepCount = scanner.nextInt();
        System.out.println(integral.monteCarloIntegration(calculator, bottomEdge, topEdge, stepCount));
    }
}
