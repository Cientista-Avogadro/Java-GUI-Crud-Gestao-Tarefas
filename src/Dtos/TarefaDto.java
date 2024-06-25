
package Dtos;

import Models.Usuario;
import java.time.LocalDate;


public class TarefaDto {
    private String Title;
    private String Description;
    private Boolean Status;

    public TarefaDto(String Title, String Description, Boolean Status) {
        this.Title = Title;
        this.Description = Description;
        this.Status = Status;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    
}
