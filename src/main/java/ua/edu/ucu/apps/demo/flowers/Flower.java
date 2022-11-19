package ua.edu.ucu.apps.demo.flowers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.edu.ucu.apps.demo.Item;

import javax.persistence.*;

@Setter
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flower_generator")
    private int id;
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flType;

    @Override
    public double price() {
        return this.price;
    }
}
