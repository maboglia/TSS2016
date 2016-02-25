import java.util.Comparator;

/**
 * Created by mauro on 22/12/15.
 */
public class CognomeComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        int r = p1.getNome().compareTo(p2.getNome());
        if (r == 0) {
            r = p1.getCognome().compareTo(p2.getCognome());
        }
        return r;
    }
}