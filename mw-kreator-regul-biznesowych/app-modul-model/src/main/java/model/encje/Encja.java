package model.encje;

import javax.persistence.*;

@MappedSuperclass
public class Encja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "WERSJA", columnDefinition = "integer DEFAULT 1", nullable = false)
    private Long wersja =1L ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWersja() {
        return wersja;
    }

    public void setWersja(Long wersja) {
        this.wersja = wersja;
    }
}
