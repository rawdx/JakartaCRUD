package servicios;

import java.util.List;

import daos.Acceso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class GestionAcceso implements IGestionAcceso {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

	@Override
	public void insertarAcceso(Acceso acceso) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(acceso);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Acceso> leerAcceso(Long id) {
		EntityManager em = emf.createEntityManager();
        List<Acceso> listaAccesos = null;

        try {
            // Utilizar una consulta JPQL diferente según si el parámetro ID es nulo o no.
            String jpql = (id != null) ? "SELECT a FROM Acceso a WHERE a.idAcceso = :id" : "SELECT a FROM Acceso a";
            
            TypedQuery<Acceso> consulta = em.createQuery(jpql, Acceso.class);

            // Establecer el parámetro ID si es proporcionado.
            if (id != null) {
                consulta.setParameter("id", id);
            }

            // Obtener la lista de resultados.
            listaAccesos = consulta.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

        return listaAccesos;
    }

	@Override
	public void actualizarAcceso(Acceso acceso) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(acceso);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			em.close();
		}
	}
	
	@Override
	public void eliminarAcceso(Long id) {
		EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Acceso acceso = em.find(Acceso.class, id);
            if (acceso != null) {
                em.remove(acceso);
                System.out.println("El registro con id " + id + " se ha borrado.");
            }else {
            	System.err.println("El registro con id " + id + " no existe.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e);
        } finally {
            em.close();
        }
	}

}
