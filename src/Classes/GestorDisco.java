package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDisco {
    private List<Disco> discos;

    public GestorDisco() {
        this.discos = new ArrayList<>();
    }

    public void setDiscos(Disco disco) {
        this.discos.add(disco);
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public List<Disco> getDiscosConXVentas(int xVentas) {
        return discos.stream().filter(disco -> disco.getVentasTotales() >= xVentas).collect(Collectors.toList());
    }
    
}
