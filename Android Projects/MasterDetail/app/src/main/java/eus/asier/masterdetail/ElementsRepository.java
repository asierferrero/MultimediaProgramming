package eus.asier.masterdetail;

import java.util.ArrayList;
import java.util.List;

public class ElementsRepository {

    List<Element> elements = new ArrayList<>();

    public interface Callback {
        void whenFinish(List<Element> elements);
    }
    ElementsRepository(){
        elements.add(new Element(R.drawable.luca, "Luca Zidane", "8.2", "Luca Zidane (Marsella, 13 de mayo de 1998) es un futbolista hispano-francés que juega como guardameta en la S. D. Eibar de la Segunda División de España. Es hijo del exfutbolista Zinedine Zidane. Posee la doble nacionalidad ya que su madre es de origen español, eligiendo el apellido de ésta como el suyo deportivo como medida familiar y del club para evitar comparaciones con su padre."));
        elements.add(new Element(R.drawable.tejero, "Álvaro Tejero", "7.9", "Álvaro Tejero Sacristán (Collado Villalba, Madrid, Comunidad de Madrid, España, 20 de julio de 1996), más conocido como Álvaro Tejero, es un futbolista español que juega como defensa en la S. D. Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.berrocal, "Juan Berrocal", "7.7", ""));
        elements.add(new Element(R.drawable.arbilla, "Anaitz Arbilla", "7.8", ""));
        elements.add(new Element(R.drawable.matheus, "Matheus Pereira", "8.4", ""));
        elements.add(new Element(R.drawable.aketxe, "Ager Aketxe", "8.8", ""));
        elements.add(new Element(R.drawable.mario, "Mario Soriano", "8.6", ""));
        elements.add(new Element(R.drawable.konrad, "Konrad de la Fuente", "7.3", ""));
        elements.add(new Element(R.drawable.quique, "Quique González", "7.2", ""));
        elements.add(new Element(R.drawable.stoichkov, "Stoichkov", "8.5",""));
    }
    public List<Element> get() {
        return elements;
    }
}