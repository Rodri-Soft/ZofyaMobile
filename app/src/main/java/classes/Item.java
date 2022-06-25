package classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("sku")
    @Expose
    private String SKU;

    @SerializedName("description")
    @Expose
    private String Description;

    @SerializedName("discount")
    @Expose
    private double Discount;

    @SerializedName("name")
    @Expose
    private String Name;

    @SerializedName("price")
    @Expose
    private String Price;

    @SerializedName("category")
    @Expose
    private String Category;

    @SerializedName("gender")
    @Expose
    private String Gender;

    @SerializedName("status")
    @Expose
    private String Status;

    @SerializedName("care")
    @Expose
    private String Care;

    @SerializedName("stock")
    @Expose
    private String Stock;

    @SerializedName("sizes")
    @Expose
    private List<String> Sizes;

    @SerializedName("colors")
    @Expose
    private List<String> Colors;

    @SerializedName("images")
    @Expose
    private List<String> Images;

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCare() {
        return Care;
    }

    public void setCare(String care) {
        Care = care;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public List<String> getSizes() {
        return Sizes;
    }

    public void setSizes(List<String> sizes) {
        Sizes = sizes;
    }

    public List<String> getColors() {
        return Colors;
    }

    public void setColors(List<String> colors) {
        Colors = colors;
    }

    public List<String> getImages() {
        return Images;
    }

    public void setImages(List<String> images) {
        Images = images;
    }
}
