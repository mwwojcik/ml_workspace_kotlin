package model.encje;

import javax.persistence.*;

@Entity
@Table(name = "parametry_wywolania_regul")
public class ParametrWywolaniaRegulyEncja extends Encja{

    @ManyToOne
    @JoinColumn(name="wywolanie_id")
    private WywolanieRegulyEncja wywolanie;

    @OneToOne
    @JoinColumn(name = "parametr_reg_wolajacej_id")
    private ParametrRegulyEncja parametrRegulyWolajacej;

    @OneToOne
    @JoinColumn(name = "parametr_reg_wolanej_id")
    private ParametrRegulyEncja parametrRegulyWolajanej;


    public WywolanieRegulyEncja getWywolanie() {
        return wywolanie;
    }

    public void setWywolanie(WywolanieRegulyEncja wywolanie) {
        this.wywolanie = wywolanie;
    }

    public ParametrRegulyEncja getParametrRegulyWolajacej() {
        return parametrRegulyWolajacej;
    }

    public void setParametrRegulyWolajacej(ParametrRegulyEncja parametrRegulyWolajacej) {
        this.parametrRegulyWolajacej = parametrRegulyWolajacej;
    }

    public ParametrRegulyEncja getParametrRegulyWolajanej() {
        return parametrRegulyWolajanej;
    }

    public void setParametrRegulyWolajanej(ParametrRegulyEncja parametrRegulyWolajanej) {
        this.parametrRegulyWolajanej = parametrRegulyWolajanej;
    }
}
