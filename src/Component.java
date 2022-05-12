public class Component {
    private double price;
    private final boolean AKTIV;
    private String description;

    public Component(double price, boolean AKTIV, String description ){
        this.price = price;
        this.AKTIV = AKTIV;
        this.description = description;

    }

    public double getPrice() {
        return price;
    }

    public boolean isAktiv() {

        return AKTIV;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Component{" +
                "price=" + price +
                ", AKTIV=" + AKTIV +
                ", description='" + description + '\'' +
                '}';
    }
}
