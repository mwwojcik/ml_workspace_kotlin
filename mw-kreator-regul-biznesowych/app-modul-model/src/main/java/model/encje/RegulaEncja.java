package model.encje;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

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
    @Fetch( FetchMode.SELECT) //uwaga bez tego zduplikowane rekordy
    private List<ParametrRegulyEncja> parametry=null;


    @OneToMany(mappedBy = "regulaWolajaca", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch( FetchMode.SELECT)
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
