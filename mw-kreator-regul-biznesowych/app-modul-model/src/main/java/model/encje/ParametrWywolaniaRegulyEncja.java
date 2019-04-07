package model.encje;

import javax.persistence.*;

@Entity
@Table(name = "parametry_wywolania_regul")
public class ParametrWywolaniaRegulyEncja extends Encja{

    @ManyToOne
    @JoinColumn(name="wywolanie_id")
    private WywolanieRegulyEncja wywolanie;

    @Column(name = "nazwa_parametru_reg_wolajaca")
    private String nazwaParametruRegulaWolajaca;

    @Column(name = "nazwa_parametru_reg_wolana")
    private String getNazwaParametruRegulaWolana;


    public WywolanieRegulyEncja getWywolanie() {
        return wywolanie;
    }

    public void setWywolanie(WywolanieRegulyEncja wywolanie) {
        this.wywolanie = wywolanie;
    }

    public String getNazwaParametruRegulaWolajaca() {
        return nazwaParametruRegulaWolajaca;
    }

    public void setNazwaParametruRegulaWolajaca(String nazwaParametruRegulaWolajaca) {
        this.nazwaParametruRegulaWolajaca = nazwaParametruRegulaWolajaca;
    }

    public String getGetNazwaParametruRegulaWolana() {
        return getNazwaParametruRegulaWolana;
    }

    public void setGetNazwaParametruRegulaWolana(String getNazwaParametruRegulaWolana) {
        this.getNazwaParametruRegulaWolana = getNazwaParametruRegulaWolana;
    }
}
