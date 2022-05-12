public class ComponentManager {
    private Component[] parts = new Component[10];
    private int counter = 0;


    //fügt eine Komponente zum Array components hinzu, was mit dem Kauf
    // der Komponenten gleichzusetzen ist

    public void buyComponent(Component part) {
        if (counter < parts.length) {
            parts[counter] = part;
            counter++;
        }
    }

    //gibt alle gekauften Komponenten als String zurück
    public String outputList() throws NullPointerException {
        String x = "";
        if (parts[0] == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] != null) {
                x += parts[i];
            }
        }
        return x;
    }

    //liefert die Gesamtzahl der gekauften Komponenten
    public int getTotalNumber() {
        int bought = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] != null) {
                bought++;
            }
        }
        return bought;
    }

    //sucht unter den gekauften Komponenten (d.h. im Array) nach der Bezeichnung einer Komponente und
    // liefert die Komponente zurück, falls gefunden, und null sonst
    public Component searchComponent(String name) throws NullPointerException {
        if (parts[0] == null){
            throw new NullPointerException("Die Liste ist leer");
        }

        for (int i = 0; i < parts.length; i++) {
            if (parts[i] != null && parts[i].getDescription().equals(name)) {
                return parts[i];
            }
        }

        return null;
    }


    //liefert den Gesamtpreis aller gekauften Komponenten zurück
    public double calculatePrice() throws IllegalArgumentException {
        double erg = 0;

        for (int i = 0; i < parts.length; i++) {

            if (parts[i] != null) {
                if(parts[i].getPrice()<1){
                    throw new IllegalArgumentException("Mindestbestellwert");
                }
                erg += parts[i].getPrice();
            }
            //Fehlermeldung schmeißen
            if (erg < 0){
                throw new IllegalArgumentException("Fehler in der Rechnung");
                    //erg = 0;------------------------------------------------------
            }
        }
        return erg;
    }

    //liefert den Gesamtpreis aller aktiven bzw. passiven gekauften Komponenten zurück
    public double calculatePrice(boolean active) {
        double erg = 0;
        for (Component element : parts) {

            if (element != null && element.isAktiv() == active) {
                erg += element.getPrice();
            }

        }
        return erg;
    }


    //liefert die Gesamtzahl der Betriebsstunden für die gekauften Komponenten zurück
    public int calculateOperatingHours() {
        int totalHours = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] != null && parts[i] instanceof UsedPart) { // ist die Komponente erbt/beinhaltet sie die Klasse die man hinter instanceof angebe
                 totalHours += ((UsedPart) parts[i]).getOperatingHours();
            }
        }

        return totalHours;
    }



}

