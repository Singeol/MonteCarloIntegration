# **Вычисление интеграла методом Монте-Карло**

Данный код вычисляет определенный интеграл функции методом Монте-Карло.

## **Файлы**

* **'Main.java'**: основной класс, содержащий метод **'monteCarloIntegration'**, осуществляющий численное 
интегрирование методом Монте-Карло, и метод **'main'**, запускающий программу.
* **'Calculator.java'**: класс, содержащий метод **'func'**, вычисляющий значение функции в точке.
* **'README.md'**: файл, который вы читаете сейчас.

## **Использование**

Введите в консоли нижнюю и верхнюю границы интегрирования и количество шагов. Программа выведет результат вычисления определенного интеграла.

```
Введите нижнюю границу интегрирования: 0
Введите верхнюю границу интегрирования: 9
Введите количество шагов: 10000
Результат интегрирования: 243.7047
```
## **Описание алгоритма**

Алгоритм численного интегрирования методом Монте-Карло заключается в аппроксимации площади под графиком функции на 
заданном отрезке путем генерации случайных точек и подсчета количества точек, попадающих под кривую. Интеграл 
вычисляется по формуле S = (b-a) * (Ymax - Ymin) * N / M, где (b-a) - длина отрезка интегрирования, Ymax и Ymin - 
максимальное и минимальное значения функции на отрезке, N - количество точек, попадающих под кривую, 
M - общее количество точек. В данной реализации интеграл вычисляется на заданном отрезке с помощью указанного 
количества шагов.