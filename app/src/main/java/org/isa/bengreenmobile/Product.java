package org.isa.bengreenmobile;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private int id;

    @SerializedName("rubrique_id")
    private int rubriqueId;

    @SerializedName("products_name")
    private String productsName;

    @SerializedName("products_description")
    private String productsDescription;

    @SerializedName("products_price")
    private float productsPrice;

    @SerializedName("rubrique_name")
    private String rubriqueName;

    @SerializedName("products_picture")
    private String productsPicture;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param productsDescription
     * @param productsPrice
     * @param rubriqueId
     * @param rubriqueName
     * @param id
     * @param productsName
     * @param productsPicture
     */
    public Product(int id, int rubriqueId, String productsName, String productsDescription, float productsPrice, String rubriqueName, String productsPicture) {
        this.id = id;
        this.rubriqueId = rubriqueId;
        this.productsName = productsName;
        this.productsDescription = productsDescription;
        this.productsPrice = productsPrice;
        this.rubriqueName = rubriqueName;
        this.productsPicture = productsPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRubriqueId() {
        return rubriqueId;
    }

    public void setRubriqueId(int rubriqueId) {
        this.rubriqueId = rubriqueId;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public String getProductsDescription() {
        return productsDescription;
    }

    public void setProductsDescription(String productsDescription) {
        this.productsDescription = productsDescription;
    }

    public float getProductsPrice() {
        return productsPrice;
    }

    public void setProductsPrice(float productsPrice) {
        this.productsPrice = productsPrice;
    }

    public String getRubriqueName() {
        return rubriqueName;
    }

    public void setRubriqueName(String rubriqueName) {
        this.rubriqueName = rubriqueName;
    }

    public String getProductsPicture() {
        return productsPicture;
    }

    public void setProductsPicture(String productsPicture) {
        this.productsPicture = productsPicture;
    }

}