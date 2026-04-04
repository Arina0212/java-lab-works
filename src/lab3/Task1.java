package lab3;

// Пример 1: Вывод последовательности x = 2*x + 1
class Example1 {
    public static void m(int x) {
        System.out.print(x + " ");
        if((2*x+1)<20){
            m(2 * x + 1);
        }
    }

    public static void main(String[] args) {
        m(1);
    }
}

// Пример 2: Вывод последовательности в обратном порядке
class Example2 {
    public static void m(int x) {
        if((2*x+1)<20){
            m(2 * x + 1);
        }
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        m(1);
    }
}

// Пример 3: Вывод до и после рекурсии
class Example3 {
    private static int step = 0;
    public static void m(int x) {
        space();
        System.out.print(" " + x + "-> ");
        step++;
        if((2*x+1)<20){
            m(2 * x + 1);
        }
        step--;
        space();
        System.out.print(" " + x + " <-");
    }
    public static void  space(){
        for (int i=0; i < step; i++){
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        m(1);
    }
}

// Пример 4: Факториал
class Example4 {
    public static long factorial(int n) {
        int result;
        if (n == 1) return 1;
        else {
            return factorial(n-1)*n;
        }

    }

    public static void main(String[] args) {
            System.out.println( factorial(5));
    }
}

// Пример 5: Числа Фибоначчи
class Example5 {
    private static int depth = 0;

    public static long fibonacci(int n) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println("fib(" + n + ")");
        depth++;

        if (n == 0) {
            depth--;
            return 0;
        }
        if (n == 1) {
            depth--;
            return 1;
        }

        long result = fibonacci(n - 1) + fibonacci(n - 2);
        depth--;
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        long result = fibonacci(n);
        System.out.println(result);
    }
}

