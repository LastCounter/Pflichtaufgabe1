public class NewPart extends Component{
    boolean packaged; // Angabe, ob die Komponente verpackt ist

    public NewPart(double price, boolean aktiv, String description, boolean packaged){
        super(price, aktiv, description);
        this.packaged = packaged;
    }

    public void setPackaged(boolean packaged) {
        this.packaged = packaged;
    }

    @Override
    public String toString() {
        return "NewPart{" +  super.toString() + //werte von der VaterKlasse
                "packaged=" + packaged +
                '}';
    }
}
