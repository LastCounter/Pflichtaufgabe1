public class UsedPart extends Component{
    private int operatingHours;

    public UsedPart(double price, boolean aktiv, String description, int operatingHours){
        super(price,aktiv,description);
        this.operatingHours = operatingHours;

    }

    public int getOperatingHours() {
        return operatingHours;
    }

    @Override
    public String toString() {
        return "UsedPart{" + super.toString() + //werte von der VaterKlasse
                "operatingHours=" + operatingHours +
                '}';
    }
}
