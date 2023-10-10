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
        elements.add(new Element(R.drawable.berrocal, "Juan Berrocal", "7.7", "Juan Berrocal González es un futbolista español que juega como defensa en la Sociedad Deportiva Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.arbilla, "Anaitz Arbilla", "7.8", "Anaitz Arbilla Zabala (Pamplona, Navarra, España, 15 de mayo de 1987) es un futbolista español. Juega de defensa en la S. D. Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.matheus, "Matheus Pereira", "8.4", "Matheus Pereira da Silva (São Paulo, Brasil, 25 de febrero de 1998), conocido solo como Matheus Pereira, es un futbolista brasileño que juega como centrocampista y su equipo es la S. D. Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.aketxe, "Ager Aketxe", "8.8", "Ager Aketxe Barrutia, más conocido como Aketxe (Bilbao, 30 de diciembre de 1993) es un jugador de fútbol español que juega como centrocampista en la S. D. Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.mario, "Mario Soriano", "8.6", "Mario Soriano Carreño (Alcalá de Henares el 22 de abril de 2002), es un futbolista español, que juega de centrocampista cedido en la SD Eibar de la Segunda División de España por el RC Deportivo de La Coruña."));
        elements.add(new Element(R.drawable.konrad, "Konrad de la Fuente", "7.3", "Konrad de la Fuente (Miami, Florida, 16 de julio de 2001) es un futbolista estadounidense que juega como delantero en la S. D. Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.quique, "Quique González", "7.2", "Enrique González Casín (Valladolid, España; 16 de mayo de 1990), más conocido como Quique González, es un futbolista español. Juega de delantero y su equipo es la Sociedad Deportiva Eibar de la Segunda División de España."));
        elements.add(new Element(R.drawable.stoichkov, "Stoichkov", "8.5","Juan Diego Molina Martínez (San Roque, 5 de noviembre de 1993), deportivamente conocido como Stoichkov, es un futbolista profesional español que juega como centrocampista ofensivo o delantero en la S. D. Eibar de la Segunda División de España."));
    }
    public List<Element> get() {
        return elements;
    }
}