package model.encje;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wywolania_regul")
public class WywolanieRegulyEncja extends Encja{


    @ManyToOne
    @JoinColumn(name = "regula_wolajaca_id")
    private RegulaEncja regulaWolajaca;

    @ManyToOne
    @JoinColumn(name = "regula_wolana_id")
    private RegulaEncja regulaWolana;

    @OneToMany(mappedBy = "wywolanie", cascade = CascadeType.ALL)
    private List<ParametrWywolaniaRegulyEncja> parametry=null;

    public RegulaEncja getRegulaWolajaca() {
        return regulaWolajaca;
    }

    public void setRegulaWolajaca(RegulaEncja regulaWolajaca) {
        this.regulaWolajaca = regulaWolajaca;
    }

    public RegulaEncja getRegulaWolana() {
        return regulaWolana;
    }

    public void setRegulaWolana(RegulaEncja regulaWolana) {
        this.regulaWolana = regulaWolana;
    }

    public List<ParametrWywolaniaRegulyEncja> getParametry() {
        return parametry;
    }

    public void setParametry(List<ParametrWywolaniaRegulyEncja> parametry) {
        this.parametry = parametry;
    }
}