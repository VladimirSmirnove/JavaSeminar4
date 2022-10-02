
public class kalkulator {
    public static final int a = 2;
    public static final int b = 10;
    public static final int x = 1;
    public static final int y = 2;

    public static int commands (int a)
    {
		if (a == b) {return 1;}
    if (a<b){return commands(a+x) + commands(a*y);} 
		{return 0;}
    }
    public static void main(String[] args) {
      
        int res = commands(a);
        System.out.println("Число А: " + a + "\n" + "Число B: " + b + "\n" + "Количество команд преобразования числа А в число В: " + res);
      }
}


