package com.champ.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity //db'de tabloya karsılık geldiğini belirtiyoruz.
@Table(name = "project")
@Data //getter-setterları olusturuyor.
@NoArgsConstructor //boş bir constructor yaratıyor.
@AllArgsConstructor //tüm fieldları kapsayan bir constructor yaratıyor.
@ToString //nesnenin stringini olusturuyor.
@EqualsAndHashCode //equals ve hashcode metotlarını override ediyor.
public class Project extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="project_code",length = 30)
    private String projectCode;

    @Column(name = "project_name",length = 300)
    private String projectName;

    @JoinColumn(name="manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
