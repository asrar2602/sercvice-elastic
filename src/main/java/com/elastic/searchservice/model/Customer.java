package com.elastic.searchservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class Customer {

    @Column(name = "serial_number")
    private String serial_number;
    @Id
    @Column(name = "Customer_Id")
    private String Customer_Id ;

    @Column(name = "First_Name")
    private String First_Name;
    @Column(name = "Last_Name")
    private String Last_Name;
    @Column(name = "Company")
    private String Company;
    @Column(name = "City")
    private String City;
    @Column(name = "Country")
    private String Country;
    @Column(name = "Phone_1")
    private String Phone_1;
    @Column(name = "Phone_2")
    private String Phone_2;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Subscription_Date")
    private String Subscription_Date;
    @Column(name = "Website")
    private String Website;

}
