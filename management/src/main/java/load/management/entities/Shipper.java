package load.management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactinfo")
    private String contactInfo;

    @Column(name = "location_a")
    private int locationA;

    @Column(name = "location_b")
    private int locationB;

    @OneToMany(mappedBy = "shipper")
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

    public int getLocationA() {
        return locationA;
    }

    public void setLocationA(int locationA) {
        this.locationA = locationA;
    }

    public int getLocationB() {
        return locationB;
    }

    public void setLocationB(int locationB) {
        this.locationB = locationB;
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
        Shipper shipper = (Shipper) o;
        return getId() == shipper.getId() && getLocationA() == shipper.getLocationA() && getLocationB() == shipper.getLocationB() && Objects.equals(getName(), shipper.getName()) && Objects.equals(getContactInfo(), shipper.getContactInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getContactInfo(), getLocationA(), getLocationB());
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", locationA=" + locationA +
                ", locationB=" + locationB +
                '}';
    }
}
