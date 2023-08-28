package load.management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carrier")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactinfo")
    private String contactInfo;

    @OneToMany(mappedBy = "carrier")
    @JsonIgnore
    private List<Load> loads;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Load> getLoads() {
        return loads;
    }

    public void setLoads(List<Load> loads) {
        this.loads = loads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrier carrier = (Carrier) o;
        return getId() == carrier.getId() && Objects.equals(getName(), carrier.getName()) && Objects.equals(getContactInfo(), carrier.getContactInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getContactInfo());
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
