import java.util.Scanner;
import java.lang.Math;

public class Main {
    // Метод Монте-Карло для численного интегрирования
    public double monteCarloIntegration(Calculator calculator, double bottomEdge, double topEdge, int stepCount) {
        double Ymin = Double.MAX_VALUE; // Минимальное значение y
        double Ymax = Double.MIN_VALUE; // Максимальное значение y
        // Поиск минимального и максимального значения y на заданном интервале
        for (double i = bottomEdge; i <= topEdge; i++){
            double y = calculator.func(i);
            Ymin = Math.min(Ymin, y);
            Ymax = Math.max(Ymax, y);
        }
        int Nbottom = 0; // Количество точек под кривой
        // Генерация случайных точек и подсчет количества точек под кривой
        for (int i = 0; i < stepCount; i++){
            double x = bottomEdge + Math.random() * (topEdge - bottomEdge);
            double y = Ymin + Math.random() * (Ymax - Ymin);
            if(y <= Ymin + calculator.func(x)){
                Nbottom++;
            }
        }
        // Оценка площади под кривой функции
        return (topEdge - bottomEdge) * (Ymax - Ymin) * (double) Nbottom / (double) stepCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Main integral = new Main();
        // Ввод пользовательских данных
        System.out.print("Введите нижнюю границу интегрирования: ");
        double bottomEdge = scanner.nextDouble(); // Нижний предел
        System.out.print("Введите верхнюю границу интегрирования: ");
        double topEdge = scanner.nextDouble(); // Верхний предел
        System.out.print("Введите количество шагов: ");
        int stepCount = scanner.nextInt(); // Количество шагов
        // Вызов метода для оценки площади под кривой функции и вывод результата на экран
        System.out.println("Результат интегрирования: " + integral.monteCarloIntegration(calculator, bottomEdge, topEdge, stepCount));
    }
}