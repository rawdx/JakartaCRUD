package servicios;

import daos.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionUsuario implements IGestionUsuario {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	
	@Override
	public void crearUsuario(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
	}

	@Override
	public Usuario leerUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		
	}

}
