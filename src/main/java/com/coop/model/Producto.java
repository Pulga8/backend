package com.coop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coop.model.dto.ProductoSintetico;

@NamedNativeQueries({
		@NamedNativeQuery(
				name="productoSintetico",
				query="SELECT p.id as codigo, p.descripcion, r.rubro, precio FROM productos p inner join rubros r on p.id_rubro=r.id  where precio>? order by rubro",
				resultSetMapping="productoSinteticoMapper"
				)
		
})
//codigo está de ejemplo para demostrar que hay que cargar el mismo nombre que la consulta
@SqlResultSetMappings({
	@SqlResultSetMapping(
			name="productoSinteticoMapper",
			classes= {
					@ConstructorResult(
							targetClass=ProductoSintetico.class,
							columns= {
									@ColumnResult(name="codigo",type=Long.class),
									@ColumnResult(name="descripcion",type=String.class),
									@ColumnResult(name="rubro",type=String.class),
									@ColumnResult(name="precio",type=Double.class)
							}
							)
			}
			)
})

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 6567964114155098009L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100, name = "descripcion")
	private String producto;

	@ManyToOne // muchos Prodcçuctos a un rubro, con foreign key siempre del lado del muchos
	@JoinColumn(name = "id_rubro") // ForeignKey
	private Rubro rubro;

	@ManyToMany
	@JoinTable(name="productos_proveedores",
		joinColumns= { 
					@JoinColumn(name="id_producto",
							referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(
						name = "id_proveedor",
						referencedColumnName = "id")})
			
	
	
	private List<Proveedor> proveedores;

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	private double precio;
	private Date fechaVencimiento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Transient
	public double getPrecioDouble() {
		return getPrecio() * 2;
	}

}
//uno Productos con proveedores a través de una
// tabla
// intermedia, con clave foranea "id", Cantidad
// de JoinColumn como atributos tenga
