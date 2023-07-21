package com.example.crm_amosys_orass.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "meta_data")
public class MetaData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long idMeta;
    @Column(name ="telephone")
    private String teleFixe;
    @Column(name ="identifiantfiscal")
    private String identifiantfiscal;
    @Column(name ="lagrement")
    private Date lagrement;
    @Column(name ="email")
    private String email;
    @Column(name ="typeActivite")
    private String typeActivite;
    @Column(name ="timeZone")

    private String timeZone;
   /* @Column(name ="IdentifiantFiscal")
    private String  identifiantsFiscal;
  */
    @ManyToOne
    @JoinColumn(name="idClient")
    private ClientEntity client;

}
