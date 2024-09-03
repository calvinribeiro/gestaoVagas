package br.com.calvinribeiro.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "candidate")
@Data
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @NotBlank
    @Pattern (regexp = "\\S+", message = "O campo (username) nao deve conter espaco")
    private String username;
    
    @Email(message = "o campo deve ser valido")
    private String email;

    @Length(min = 6, max = 20)
    private String password;
    private String description;


    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
