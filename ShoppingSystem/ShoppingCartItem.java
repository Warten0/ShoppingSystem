package ShoppingSystem;

public class ShoppingCartItem {
    public int ID;
    public String proName;
    private Product product;
    private int quantity;
    public  double retailPrice;

    public ShoppingCartItem(int id,String name, int quantity,double retailPrice) {
        //this.product = product;
        this.ID = id;
        this.proName = name;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
    }

    public Object getProduct() {
        return product;
    }

    public int getID(){
        return ID;
    }

    public String getProName(){
        return proName;
    }

    public void setQuantity(int amount){
        quantity = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getRetailPrice(){
        return retailPrice;
    }

}