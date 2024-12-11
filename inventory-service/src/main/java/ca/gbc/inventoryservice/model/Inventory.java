package ca.gbc.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 //   @Column(name = "skucode") // Maps to 'sku_code' in DB ****
    private String skuCode;
 //   @Column(name = "quantity") // Maps to 'quantity' in DB ****
    private Integer quantity;
}