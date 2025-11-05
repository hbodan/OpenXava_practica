package ni.edu.uam.facturacion.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Direccion {

    @Column(length = 50)
    String viaPublica;

    @Column(length = 5)
    String codigoPostal;

    @Column(length = 20)
    String municipio;

    @Column(length = 30)
    String provincia;

}
