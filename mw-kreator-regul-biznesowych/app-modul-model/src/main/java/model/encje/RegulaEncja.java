package model.encje;

import model.nlp.Sekwencja;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reguly")
public class RegulaEncja extends Encja{

    private String kod;

    private String tresc;


    public RegulaEncja() {
    }

    public RegulaEncja(String kod, String tresc) {
        this.kod = kod;
        this.tresc = tresc;
    }

    @OneToMany(mappedBy = "regula", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ParametrRegulyEncja> parametry=null;

    @Transient
    private  Sekwencja sekwencja ;



    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public List<ParametrRegulyEncja> getParametry() {
        return parametry;
    }

    public void setParametry(List<ParametrRegulyEncja> parametry) {
        this.parametry = parametry;
    }

    public Sekwencja getSekwencja() {
        return sekwencja;
    }

    public void setSekwencja(Sekwencja sekwencja) {
        this.sekwencja = sekwencja;
    }
}
