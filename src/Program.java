public class Program {
    public static void main(String[] args) {
        NewPart kabelN = new NewPart(9.99, true, "Handy Kabel1", true);
        UsedPart kabelU = new UsedPart(4.99, false, "Handy Kabel2", 100);

        ComponentManager list1 = new ComponentManager();

        list1.buyComponent(kabelN);

        list1.buyComponent(kabelU);

        System.out.println("OutputList:  " + list1.outputList());

        System.out.println("getTotalNumber: " + list1.getTotalNumber());


        System.out.println("Gesamtpreis: " + list1.calculatePrice());
        System.out.println("searchComponent" +list1.searchComponent("Handy Kabel1"));
        System.out.println("Aktiv/Passiv: "+list1.calculatePrice(true));
        System.out.println("in Benutzung: " +list1.calculateOperatingHours());
    }


}
