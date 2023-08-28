package load.management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    @Column(name = "amount")
    private int amount;

    @Column(name = "pickupid")
    private int pickupId;

    @Column(name = "deliveryid")
    private int deliveryId;

    private int shipperid;

    private Integer carrierid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "shipperid",referencedColumnName = "id",insertable = false,updatable = false)
    private Shipper shipper;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "carrierid",referencedColumnName = "id",insertable = false,updatable = false)
    private Carrier carrier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPickupId() {
        return pickupId;
    }

    public void setPickupId(int pickupId) {
        this.pickupId = pickupId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperId) {
        this.shipperid = shipperId;
    }

    public Integer getCarrierid() {
        return carrierid;
    }

    public void setCarrierid(Integer carrierId) {
        this.carrierid = carrierId;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Load load = (Load) o;
        return getId() == load.getId() && getWeight() == load.getWeight() && getAmount() == load.getAmount() && getPickupId() == load.getPickupId() && getDeliveryId() == load.getDeliveryId() && getShipperid() == load.getShipperid() && Objects.equals(getDescription(), load.getDescription()) && Objects.equals(getCarrierid(), load.getCarrierid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getWeight(), getAmount(), getPickupId(), getDeliveryId(), getShipperid(), getCarrierid());
    }

    @Override
    public String toString() {
        return "Load{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", amount=" + amount +
                ", pickupId=" + pickupId +
                ", deliveryId=" + deliveryId +
                ", shipperid=" + shipperid +
                ", carrierid=" + carrierid +
                '}';
    }
}
