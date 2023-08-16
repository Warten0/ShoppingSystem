package ShoppingSystem;

public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private String productionDate;
    private String model;
    private double purchasePrice;
    private double retailPrice;
    private int quantity;

    public Product(int id, String name, String manufacturer, String productionDate, String model, double purchasePrice, double retailPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }

    public void setId(int ID){
        id = ID;
    }

    public int getId() {
        return id;
    }

    public void setName(String Name){
        name = Name;
    }

    public String getName() {
        return name;
    }

    public void setManufacturer(String Manufacturer){
        manufacturer = Manufacturer;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setProductionDate(String data){
        productionDate = data;
    }

    public String getProductionDate(){
        return productionDate;
    }

    public void setModel(String Model){
        model = Model;
    }

    public String getModel(){
        return model;
    }

    public void setPurchasePrice(double PurchasePrice){
        purchasePrice = PurchasePrice;
    }

    public double getPurchasePrice(){
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int i) {
        quantity = i;
    }

    public void setRetailPrice(double RetailPrice){
        retailPrice = RetailPrice;
    }

    public double getRetailPrice(){
        return retailPrice;
    }

}
