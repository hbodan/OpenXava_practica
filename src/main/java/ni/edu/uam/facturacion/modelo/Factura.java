package ni.edu.uam.facturacion.modelo;

import jdk.internal.vm.annotation.Hidden;
import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.facturacion.calculadores.CalculadorSiguienteNumeroParaAnyo;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter @Setter
public class Factura {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length=6)
    @DefaultValueCalculator(value = CalculadorSiguienteNumeroParaAnyo.class, properties = @PropertyValue(name = "anyo"))
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;

    @TextArea
    String observaciones;



}
