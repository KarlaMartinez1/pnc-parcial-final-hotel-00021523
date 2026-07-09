package com.uca.pncparcialfinalhotel.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "rooms")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private String type; // Ej: Sencilla, Doble, Suite

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean isAvailable = true;
}