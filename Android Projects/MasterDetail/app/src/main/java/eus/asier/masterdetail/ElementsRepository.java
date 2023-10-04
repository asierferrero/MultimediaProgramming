package eus.asier.masterdetail;

import java.util.ArrayList;
import java.util.List;

public class ElementsRepository {

    List<Element> elements = new ArrayList<>();

    public interface Callback {
        void whenFinish(List<Element> elements);
    }
    ElementsRepository(){
        elements.add(new Element(R.drawable.luca, "Luca Zidane", "8.2", ""));
        elements.add(new Element(R.drawable.tejero, "Álvaro Tejero", "7.9", ""));
        elements.add(new Element(R.drawable.berrocal, "Juan Berrocal", "7.7", ""));
        elements.add(new Element(R.drawable.arbilla, "Anaitz Arbilla", "7.8", ""));
        elements.add(new Element(R.drawable.cristian, "Cristian Gutierrez", "7.6", ""));
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