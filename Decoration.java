import java.io.Serializable;

public class Decoration implements Serializable {
    private String Dcoration_Items;
    private int Decoration_Items_Quantity;

    public Decoration() {

    }

    public String getDcoration_Items() {
        return Dcoration_Items;
    }

    public void setDcoration_Items(String dcoration_Items) {
        Dcoration_Items = dcoration_Items;
    }

    public int getDecoration_Items_Quantity() {
        return Decoration_Items_Quantity;
    }

    public void setDecoration_Items_Quantity(int decoration_Items_Quantity) {
        Decoration_Items_Quantity = decoration_Items_Quantity;
    }
}
