import java.util.Random;
import java.util.Scanner;
public class Aga {

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
        double average = 0;
        double sum = 0;

        double [] tmpwylosowaneWartosci = wylosowaneWartosci;
        double odchylenieSQRT = 0;
        double odchyleniePOW = 0;
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
        for(double x :wylosowaneWartosci)
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
        average = sum/tmprozmiar_tablicy;


        int z=0;
        while(z<wylosowaneWartosci.length)
        {
            if(wylosowaneWartosci[z] > average)
            {
                double[] biggerThanAverage = wylosowaneWartosci;
                System.out.println("Wartosci wieksze od sredniej to: "+biggerThanAverage[z]);
            }
            if(wylosowaneWartosci[z] < average)
            {
                double[] lowerThanAverage = wylosowaneWartosci;
                System.out.println("Wartosci mniejsze od sredniej to: "+lowerThanAverage[z]);
            }
            z++;
        }

        for(int i = 0; i<wylosowaneWartosci.length; i++)
        {
            odchyleniePOW += Math.pow((wylosowaneWartosci[i]-average), 2);
        }

        odchylenieSQRT = Math.sqrt(odchyleniePOW / wylosowaneWartosci.length);

        System.out.println("Srednia wartosc wygenerowanych liczb wynosi:" +average);
        System.out.println("Wartosc najmniejsza to: "+ min +", a najwieksza to:" +max);
        System.out.println("Odchylenie standardowe wynosi "+ odchylenieSQRT);
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