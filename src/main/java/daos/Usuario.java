package daos;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuarios", schema = "eeee")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false, columnDefinition = "BIGINT")
	private long idUsuario;

	@Column(name = "dni_usuario", nullable = false)
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;

	@Column(name = "clave")
	private String clave;

	@Column(name = "estaBloqueado")
	private boolean estaBloqueado;

	@Column(name = "fecha_fin_bloqueo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaFinBloqueo;

	@Column(name = "fecha_alta")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaAlta;

	@Column(name = "fecha_baja")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaBaja;

	@ManyToOne
	@JoinColumn(name = "acceso_id")
	Acceso acceso;


	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String dni, String nombre, String apellidos, String telefono,
			String email, String clave, boolean estaBloqueado, Calendar fechaFinBloqueo,
			Calendar fechaAlta, Calendar fechaBaja, Acceso acceso) {
		super();
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.clave = clave;
		this.estaBloqueado = estaBloqueado;
		this.fechaFinBloqueo = fechaFinBloqueo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.acceso = acceso;
	}

	public Usuario(String dni, String nombre, String apellidos, String telefono,
			String email, String clave, boolean estaBloqueado, Acceso acceso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.clave = clave;
		this.estaBloqueado = estaBloqueado;
		this.acceso = acceso;
	}
}