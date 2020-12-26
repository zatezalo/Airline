package rs.raf.Airline.model.dto.companyDto;

import lombok.Data;

@Data
public class AddCompanyDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
