package br.com.usingcache.TrainingCaches.DTO;


import br.com.usingcache.TrainingCaches.Entities.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {

    private String Nome_Completo;
    private Integer UserId;

    public PeopleDTO(People pessoa){
        this.Nome_Completo = pessoa.getFirstName() + " " + pessoa.getLastName();
        this.UserId = pessoa.getId();
    }

    public static PeopleDTO newPeopleDto(People people){
        PeopleDTO peopleUtilities = new PeopleDTO();
        peopleUtilities.setNome_Completo(people.getFirstName()+" "+ people.getLastName());
        peopleUtilities.setUserId(people.getId());
        return peopleUtilities;
    }

    public static Page<PeopleDTO> pageToPeopleDTO(Page<People> people){
        return people.map(PeopleDTO::new);
    }
}
