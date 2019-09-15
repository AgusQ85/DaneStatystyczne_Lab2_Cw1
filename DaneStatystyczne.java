import java.util.Random;
import java.util.Scanner;
public class DaneStatystyczne {

    public static void main(String[] args)
    {
        System.out.println("Podaj rozmiar tablicy: ");

        Scanner scan = new Scanner(System.in);
        int rozmiar_tablicy = scan.nextInt();
        int tmprozmiar_tablicy = rozmiar_tablicy;

        double[] losujZ = {2.0, 3.0, 3.5, 4.0, 4.5, 5.0};
        double[] wylosowaneWartosci = new double[rozmiar_tablicy];

        double min = wylosowaneWartosci[0];
        double max = wylosowaneWartosci[0];
        double sredniaLiczb = 0;
        double sum = 0;

        double [] tmpwylosowaneWartosci = wylosowaneWartosci;
        double odchylenieSpierwiastkowane = 0;
        double odchylenie_Srednia = 0;
        System.out.println("Wylosowalem dla Ciebie liczby: ");

        while(rozmiar_tablicy>0)
                {
           Random randomNumber = new Random();
            int rand = randomNumber.nextInt(5);
            for(int i = 0; i<rozmiar_tablicy; i++)
            {
                wylosowaneWartosci[i]= losujZ[rand];
            }
                 rozmiar_tablicy--;
        }
        for(double x :wylosowaneWartosci) //wypisanie wylosowanych liczb
        {
            System.out.println(x);
        }

        int y=0;
        while(y<tmpwylosowaneWartosci.length)
        {
            sum+=wylosowaneWartosci[y];
            y++;
        }

        max = maksymalna(wylosowaneWartosci);
        min = minimalna(wylosowaneWartosci);
        sredniaLiczb = sum/tmprozmiar_tablicy;

        System.out.println("Srednia wartosc wygenerowanych liczb wynosi: " +sredniaLiczb);
        int z=0;
        while(z<wylosowaneWartosci.length)
        {
            if(wylosowaneWartosci[z] > sredniaLiczb)
            {
                double[] wiekszeOdSredniej = wylosowaneWartosci;
                System.out.println("Wartosci wieksze od sredniej to: "+wiekszeOdSredniej[z]);
            }

            if(wylosowaneWartosci[z] < sredniaLiczb)
            {
                double[] mniejszeOdSredniej = wylosowaneWartosci;
                System.out.println("Wartosci mniejsze od sredniej to: "+mniejszeOdSredniej[z]);
            }
            z++;
        }

        for(int i = 0; i<wylosowaneWartosci.length; i++)
        {
            odchylenie_Srednia += Math.pow((wylosowaneWartosci[i]-sredniaLiczb), 2);
        }

        odchylenieSpierwiastkowane = Math.sqrt(odchylenie_Srednia / wylosowaneWartosci.length);


        System.out.println("Wartosc najmniejsza to: "+ min +", a najwieksza to: " +max);
        System.out.println("Odchylenie standardowe wynosi: "+ odchylenieSpierwiastkowane);
    }

    public static double maksymalna(double[] inputArray)
    {
        double wartoscMax = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > wartoscMax){
                wartoscMax = inputArray[i];
            }
        }
        return wartoscMax;
    }

    public static double minimalna(double[] inputArray)
    {
        double wartoscMin = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < wartoscMin){
                wartoscMin = inputArray[i];
            }
        }
        return wartoscMin;
    }
}