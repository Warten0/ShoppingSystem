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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String getProductionDate(){
        return productionDate;
    }

    public String getModel(){
        return model;
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

    public double getRetailPrice(){
        return retailPrice;
    }

}
