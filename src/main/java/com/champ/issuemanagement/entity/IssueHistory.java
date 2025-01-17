package com.champ.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //db'de tabloya karsılık geldiğini belirtiyoruz.
@Table(name = "issue_history")
@Data //getter-setterları olusturuyor.
@NoArgsConstructor //boş bir constructor yaratıyor.
@AllArgsConstructor //tüm fieldları kapsayan bir constructor yaratıyor.
@ToString //nesnenin stringini olusturuyor.
@EqualsAndHashCode //equals ve hashcode metotlarını override ediyor.
public class IssueHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Issue issue;

    @Column(name = "description",length = 1000)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatu;

    @Column(name = "details",length = 4000)
    private String details;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;
}
