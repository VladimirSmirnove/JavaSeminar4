import java.util.*;
public class Hanoii {
    static void hanoi(int n, String A, String B, String C)
    {
        if (n==0) return;
        hanoi (n-1, A, C, B);
        System.out.println("из " + A + " в " + B);
        hanoi (n-1, C, B, A);
        }
    public static void main(String[] args) 
    {
        Scanner con = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int n = con.nextInt();
        hanoi(n, "Стержень А", "Стержень B", "Стержень C");
        con.close();
    }
}
