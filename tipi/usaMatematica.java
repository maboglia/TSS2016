package it.maboglia.tipi;

public class usaMatematica {

    private double numeroUno, numeroDue;


    public usaMatematica(double uno, double due) {
        numeroUno = uno;
        numeroDue = due;

    }

    public double somma(){

       return numeroUno + numeroDue;

    }
    public void separatore(){

        String separatore = "******[][][]******";
        System.out.println(separatore);

    }



}
