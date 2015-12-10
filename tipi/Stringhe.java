package giorno2;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        String saluta = "Ciao belli!";
        String mezzoSaluto = "Ciao ";
        String altroMezzo ="belli!";
        String salutaUguale = "Ciao ";
        String meLiSommoPrima = mezzoSaluto + altroMezzo;


        System.out.println(saluta);
        System.out.println(mezzoSaluto + altroMezzo);

        boolean b = (saluta == meLiSommoPrima);
        System.out.println(b);

        boolean c = (mezzoSaluto == salutaUguale);
        System.out.println(c);

        boolean d = saluta.equals(meLiSommoPrima);
        System.out.println(d);

        char[] chars = {'c','i','a','o'};

        String e = new String(chars);
        System.out.println(e);

        char[] chars2 = e.toCharArray();
            for (char f : chars2 ) {
                System.out.println(f);
            }
        //migliorare questo codice
        String s= getInput("scrivi una bella frase");
        char[] chars3 = s.toCharArray();
        for (int i=0; i <= 44; i++ ) {
            System.out.print(chars3[i]);
            if((i % 6) == 0)
            System.out.println();
        }




    }

    public static String getInput(String domanda){

               System.out.println(domanda);
               Scanner stringa = new Scanner(System.in);
               String miaStringa = stringa.next();
               return miaStringa;
    }

}
