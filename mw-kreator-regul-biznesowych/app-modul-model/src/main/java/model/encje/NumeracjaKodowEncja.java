package model.encje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "numeracja_kodow")
public class NumeracjaKodowEncja extends Encja {
    @Column(name = "numer_kolejny")
    private Long numerKolejny;

    public Long getNumerKolejny() {
        return numerKolejny;
    }

    public void setNumerKolejny(Long numerKolejny) {
        this.numerKolejny = numerKolejny;
    }
}
