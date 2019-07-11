package app.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRequest {

    private Age age;

    private Income income;

    private boolean student;




}