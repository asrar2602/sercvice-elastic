package com.elastic.searchservice.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @Column(name = "Customer_Id")
    private String customerId;
    @Column(name = "First_Name")
    private String FirstName;
    @Column(name = "City")
    private String City;
    @Column(name = "Company")
    private String Company;

}
