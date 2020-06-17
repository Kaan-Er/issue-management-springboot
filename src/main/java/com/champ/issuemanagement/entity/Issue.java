package com.champ.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //db'de tabloya karsılık geldiğini belirtiyoruz.
@Table(name = "issue")
@Data //getter-setterları olusturuyor.
@NoArgsConstructor //boş bir constructor yaratıyor.
@AllArgsConstructor //tüm fieldları kapsayan bir constructor yaratıyor.
@ToString //nesnenin stringini olusturuyor.
@EqualsAndHashCode //equals ve hashcode metotlarını override ediyor.
public class Issue extends BaseEntity{

    @Id //tablomuzdaki id değeri oldugunu belirtiyoruz.zorunlu olarak belirtmemiz gerek.
    @GeneratedValue(strategy = GenerationType.AUTO) //idleri otomatik olarak oluşturuyoruz.
    private Long id;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "details",length = 4000)
    private String details;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatu;

    @JoinColumn(name = "assignee_user_id") //diğer tablodaki fieldla ilişkisel oldugu için joincolumn olarak belirledik.
    @ManyToOne(optional=true,fetch = FetchType.LAZY) //ManytoOne ->bir çok issue bir tane usera bağlanabilir.
    // optional=true->bir issue yaratırken bir kullancıya bağlamasan da olur.
    // lazy ise getter ile çagrıldıgında assigne getiriliyor.eager deseydik hep gelirdi.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
