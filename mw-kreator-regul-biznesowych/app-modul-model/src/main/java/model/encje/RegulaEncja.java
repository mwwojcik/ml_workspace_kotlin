package model.encje;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @OrderBy("id")
    private List<ParametrRegulyEncja> parametry=null;


    @OneToMany(mappedBy = "regulaWolajaca", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WywolanieRegulyEncja> wywolaniaRegul=null;




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

    public Set<WywolanieRegulyEncja> getWywolaniaRegul() {
        return wywolaniaRegul;
    }

    public void setWywolaniaRegul(Set<WywolanieRegulyEncja> wywolaniaRegul) {
        this.wywolaniaRegul = wywolaniaRegul;
    }
}
