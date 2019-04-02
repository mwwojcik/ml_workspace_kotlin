package model.encje;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="parametry_reguly")
public class ParametrRegulyEncja extends Encja {

    private String nazwa;
    private String typ;
    private String wartoscDomyslna;

    @ManyToOne
    private RegulaEncja regula;


    public ParametrRegulyEncja(String nazwa) {
        this.nazwa = nazwa;
    }

    public ParametrRegulyEncja() {
    }

    public ParametrRegulyEncja(String nazwa, String typ, String wartoscDomyslna) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.wartoscDomyslna = wartoscDomyslna;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getWartoscDomyslna() {
        return wartoscDomyslna;
    }

    public void setWartoscDomyslna(String wartoscDomyslna) {
        this.wartoscDomyslna = wartoscDomyslna;
    }

    public RegulaEncja getRegula() {
        return regula;
    }

    public void setRegula(RegulaEncja regula) {
        this.regula = regula;
    }
}
