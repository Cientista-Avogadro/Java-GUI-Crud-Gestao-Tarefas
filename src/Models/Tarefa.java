
package Models;

import java.time.LocalDate;


public class Tarefa {
    private Integer Id;
    private String Title;
    private String Description;
    private Boolean Status;
    private LocalDate CreatedAt;
    private LocalDate UpdatedAt;
    private Usuario CreatedBy; 
    private Usuario UpdatedBy;

    public Tarefa(Integer Id, String Title, String Description, Boolean Status, LocalDate CreatedAt, LocalDate UpdatedAt, Usuario CreatedBy, Usuario UpdatedBy) {
        this.Id = Id;
        this.Title = Title;
        this.Description = Description;
        this.Status = Status;
        this.CreatedAt = LocalDate.now();
        this.UpdatedAt = LocalDate.now();
        this.CreatedBy = CreatedBy;
        this.UpdatedBy = UpdatedBy;
    }
    
    public Tarefa(){
        
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDate CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public LocalDate getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDate UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }

    public Usuario getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Usuario CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Usuario getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(Usuario UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }
    
    
    
    
}
