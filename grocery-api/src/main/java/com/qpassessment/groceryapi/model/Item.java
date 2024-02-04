package com.qpassessment.groceryapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_id_sequence",
            sequenceName = "item_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )
    public Integer itemId;
    public String name;
    public Integer quantity;
    public Double price;
}
