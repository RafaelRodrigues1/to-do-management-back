package com.personalproject.todomanagement.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import lombok.Data
import org.hibernate.annotations.Type
import org.jetbrains.annotations.NotNull
import java.util.Date
import java.util.UUID

@Data
@Entity
@Table(name = "users")
data class User (
        @Id
        @Type(type = "uuid-char")
        var id: UUID? = null,
        @Column(name = "name")
        val name: String?,
        @Column(name = "registration", unique = true)
        val registration: String?,
        @Column(name = "email", unique = true)
        val email: String?,
        @Column(name = "senha")
        @JsonIgnore
        val senha: String?,
        @Column(name = "dt_register")
        val registerDate: Date?,
        @Enumerated(EnumType.STRING)
        val status: UserStatus
)

enum class UserStatus {
        ATIVO, INATIVO, PENDENTE, PROCESSANDO;
}
