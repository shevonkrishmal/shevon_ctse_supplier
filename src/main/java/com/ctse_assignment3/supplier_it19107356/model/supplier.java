package com.ctse_assignment3.supplier_it19107356.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "supplier")
public class supplier {

    @Id
    private int id;
    private String supplier_name;
    private String company_name;
    private String address;
    private String phone;
    private String email;
    private String item_category;

    public supplier() {
    }

    public supplier(int id, String supplier_name, String company_name, String address, String phone, String email,
            String item_category) {
        this.id = id;
        this.supplier_name = supplier_name;
        this.company_name = company_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.item_category = item_category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    @Override
    public String toString() {
        return "supplier [id=" + id + ", supplier_name=" + supplier_name + ", company_name=" + company_name
                + ", address=" + address + ", phone=" + phone + ", email=" + email + ", item_category=" + item_category + "]";
    }
}
