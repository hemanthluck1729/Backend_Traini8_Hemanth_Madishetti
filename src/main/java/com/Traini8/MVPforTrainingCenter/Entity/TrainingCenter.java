package com.Traini8.MVPforTrainingCenter.Entity;



import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Getter
@Setter
@Table(name = "training_centers")
public class TrainingCenter {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    @Column(nullable = false, length = 40)
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @Column(nullable = false, length = 12, unique = true)
    private String centerCode;

    @NotNull(message = "Address is required")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false , updatable = false)
    private Long createdOn;

    @Email(message = "Contact email must be a valid email address")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Contact phone must be a valid phone number (10-15 digits)")
    @Column(nullable = false)
    private String contactPhone;

    @PrePersist
    public void prePersist() {
        this.createdOn = Instant.now().getEpochSecond(); // Set timestamp when saving
    }


}

