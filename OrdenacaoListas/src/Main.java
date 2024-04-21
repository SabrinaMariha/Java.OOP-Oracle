import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(3);
        lista.add(2);
        lista.add(5);
        lista.add(4);
        //lista.sort(Integer::compareTo);
        Collections.sort(lista);
        System.out.println(lista);
        //lista.sort(Collections.reverseOrder());
        Collections.sort(lista, Collections.reverseOrder());
        System.out.println(lista);

        Collections.sort(lista, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a%2==0 && b%2!=0){
                    return 1;
                } else if (a%2!=0 && b%2==0) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    );
        System.out.println("números ímpares antes dos pares:"+lista);
        Collections.sort(lista, Comparator.comparingInt(a -> a%2));
        System.out.println("números pares antes dos ímpares:"+lista);
        lista.sort(Collections.reverseOrder());
        System.out.println("números ímpares antes dos pares:"+lista);
    }
}