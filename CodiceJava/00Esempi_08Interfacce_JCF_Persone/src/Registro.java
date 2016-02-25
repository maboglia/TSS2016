import java.util.*;

/**
 * Created by mauro on 22/12/15.
 */
public class Registro {

    public static void main(String[] args) {
        List persone = new ArrayList();
        persone.add(new Persona(27, "marco", "bianco"));
        persone.add(new Persona(80, "luca", "arancio"));
        persone.add(new Persona(75, "giovanni", "rossi"));
        persone.add(new Persona(29, "mario", "bianchi"));

        System.out.println("******************");
        System.out.println("Lista non ordinata");
        System.out.println("******************");
        print(persone);

        System.out.println("**************");
        System.out.println("Ordina per eta");
        System.out.println("**************");
        Collections.sort(persone);
        print(persone);

        System.out.println("***************");
        System.out.println("Ordina per nome");
        System.out.println("***************");
        Collections.sort(persone, new CognomeComparator());
        print(persone);
    }

    private static void print(Collection coll) {
        Iterator it = coll.iterator();

        while (it.hasNext()) {
            Persona p = (Persona) it.next();
            System.out.println(p.getNome() + " " +
                    p.getCognome() + " " +
                    p.getEta());
        }
    }

}
