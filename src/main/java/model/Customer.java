package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    private String id;
    private String title;
    private String name;
    private LocalDate dob;
    private String address;
    private Double salary;
}
