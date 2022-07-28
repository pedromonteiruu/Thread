package br.com.usingcache.TrainingCaches.DTO;


import br.com.usingcache.TrainingCaches.Entities.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {

    private String FullName;
    private Integer UserId;

    public PeopleDTO(List<People> pessoa){
        for(int i=0;i<pessoa.size();i++){
            this.FullName = pessoa.get(i).getFirstName() + pessoa.get(i).getLastName();
            this.UserId = pessoa.get(i).getId();
        }
    }
}
