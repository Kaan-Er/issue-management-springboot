package com.champ.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable; //nesnenin networkten tasınabilmesi ve diske yazılabilmesi gibi işlemleri sağlıyor.
import java.util.Date;

@Data //getter-setterları otomatik olarak oluşturuyor.
@MappedSuperclass // diğer classlarda extend edilebilir hale getiriyor.
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP) //oluşacak tarihin formatını belirledik.
    private Date createdAt; //kaydı ne zaman eklediğini görmek için.

    @Column(name = "created_by",length = 100)
    private String createdBy; //kaydı kim ekledi.

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt; //kaydı ne zaman güncellediğini görmek için.

    @Column(name = "updated_by",length = 100)
    private String updatedBy; //kaydın kim tarafından güncellendiğini görmek için.

    @Column(name = "status")
    private Boolean status; //kaydın durumu.
}
