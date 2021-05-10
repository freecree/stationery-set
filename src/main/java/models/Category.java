package models;

import java.util.Collection;

public class Category {
    private String name;
    private Collection<Product> products;
    private Collection<PropertyName> propertyNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Collection<PropertyName> getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(Collection<PropertyName> propertyNames) {
        this.propertyNames = propertyNames;
    }
}
