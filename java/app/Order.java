package app;

import java.util.Objects;

public class Order {
    String  name;
    Integer Id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(name, order.name) &&
                Id.equals(order.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Id);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
