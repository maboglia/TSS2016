
package it.ingaramo.c;

import javax.swing.*;
import javax.swing.JOptionPane;

public class Alunno {
    
    public static boolean isNumber (String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException nfe) {}
    return false;
    }//Metodo controllo se è un numero !! 
    
      public static void main(String[] args) {
        
        boolean errore=true;
        
        while(errore==true)
        {
        errore=false;
        JTextField numeroS = new JTextField();//creo oggetto JTextField (importato)
        JTextField annoS = new JTextField();
        Object[] messaggio = {
        "Numero alunni ", numeroS,//-- numeroS perchè è una stringa
        "Anno di nascita ", annoS,
        };
        //Impostazione finestra messaggio 
        int risp = JOptionPane.showConfirmDialog(null, messaggio, "INPUT", JOptionPane.OK_CANCEL_OPTION);
                  if (risp==JOptionPane.OK_OPTION)
                  {
                    if (isNumber(numeroS.getText())==true && isNumber(annoS.getText())==true)//anno non definito
                    {
                        int numero = Integer.parseInt(numeroS.getText());//trasformazione stringa in numero
                        int anno = Integer.parseInt(annoS.getText());
                        int classi = (numero/16);//trovare classi piu ripartizione del resto
                        if(numero%16!=0) 
                        {
                            classi++;
                        }
                        System.out.println("Da "+numero+" alunni si ottengono "+classi+" classi \nAnnata: "+anno);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Errore! Inserisca solo numeri prof.Bogliaccino-->grazie Ergi","ERRORE",JOptionPane.ERROR_MESSAGE);
                        errore=true;
                        
                    }
                    
                  } 
                  
        }//fine ciclo while
                  
                  
                  
    }   
}