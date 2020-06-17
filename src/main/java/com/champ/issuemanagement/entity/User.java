package com.champ.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true) //unique=true->aynı isimle birden fazla kişi kayıt olamaz.
    private String username;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname",length = 200)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY) //lazy secmemizin sebebi usera sectiğimizde ona ait issuelarını görmek istersek gelir.
    private List<Issue> issues;
}
