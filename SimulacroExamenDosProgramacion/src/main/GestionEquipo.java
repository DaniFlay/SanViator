package main;

import java.util.Iterator;
import java.util.List;

import entidades.Equipo;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GestionEquipo {
	private EntityManager em=null;
	public GestionEquipo() {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("gestionEquipos");
		em= factory.createEntityManager();
		
	}
	public boolean crearEquipo(Equipo equipo) {
		boolean exito=true;
		try {
			EntityTransaction tran= em.getTransaction();
			tran.begin();
			em.persist(equipo);
			tran.commit();
		} catch (Exception e) {
			exito=false;
		}
		return exito;
	}
	public boolean crearJugador(int idEquipo,Jugador jugador) {
		boolean exito=false;
		try {
			Equipo equipo= em.find(Equipo.class, idEquipo);
			if(equipo!=null) {
				EntityTransaction tran= em.getTransaction();
				tran.begin();
				List<Jugador> jugadores=equipo.getJugadores();
				jugadores.add(jugador);
				tran.commit();
			}
		} catch (Exception e) {
			exito=false;
		}
		return exito;
	}
	public boolean traspaso(int idOrigen, int idDestino, Jugador jugador) {
		EntityTransaction tran=null;
		boolean exito=true;
		try {
			Equipo equipoOrigen= em.find(Equipo.class, idOrigen);
			Equipo equipoDestino= em.find(Equipo.class, idDestino);
			if(equipoOrigen!= null && equipoDestino!=null) {
				tran=em.getTransaction();
				tran.begin();
				List<Jugador> jugadoresOrigen=equipoOrigen.getJugadores();
				List<Jugador> jugadoresDestino= equipoDestino.getJugadores();
				
				exito=jugadoresOrigen.remove(jugador);
				if(!jugadoresDestino.contains(jugador)) {
					jugadoresDestino.add(jugador);
				}
				else {
					exito=false;
				}
				tran.commit();
			}
			else {
				exito=false;
			}
		} catch (Exception e) {
			exito=false;
		}
		return exito;
	}
	public List<Jugador> buscarNombre(String nombre){
		String jpql="select j from Jugador j where j.nombre LIKE :nombreJugador";
		Query query= em.createQuery(jpql);
		query.setParameter("nombreJugador", "%"+nombre+"%");
		List<Jugador> jugadores=query.getResultList();
		return jugadores;
	}
	public List<Jugador> filtroJugadores(int edadMin, int edadMax, String posicion){
		String jpql="select j from jugador j where j.edad>=?1 and j.edad<=?2 and j.posicion=?3";
		Query query= em.createQuery(jpql);
		query.setParameter(1, edadMin);
		query.setParameter(2,edadMax);
		query.setParameter(3, posicion);
		List<Jugador> jugadores = query.getResultList();
		return jugadores;
	}
	public boolean borrarJugadores(String dni) {
		String jpql="delete from jugador j where j.dni='"+dni+"'";
		Query query=em.createQuery(jpql);
		
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		int valor= query.executeUpdate();
		tran.commit();
		return valor==1?true:false;
	}
	public int numeroJugadoresEquipos(int idEquipo) {
		String jpql="select e from Equipo e where id="+idEquipo;
		Query query=em.createQuery(jpql);
		Equipo e=(Equipo) query.getSingleResult();
		int numJugadores=e.getJugadores().size();
		return numJugadores;
	}
	public double mediaEdadEquipo(int idEquipo) {
		double media=0;
		String jpql="select avg(j.edad) from Jugador j where j.equipo.id='"+idEquipo+"'";
		Query query =em.createQuery(jpql);
		media=(double) query.getSingleResult();
		return media;
	}
	public List<Equipo> equiposDivision(String division){
		String jpql="select e from Equipo e where e.division=?1 and e.nombre !=?2";
		Query query=em.createQuery(jpql);
		query.setParameter(1, division);
		division=division.toLowerCase();
		query.setParameter(2, "JugadoresMercado"+Character.toUpperCase(division.charAt(0))+division.substring(1,division.length()-1));
		List<Equipo> equipos=query.getResultList();
		return equipos;
	}
	public void imprimirEquipos(List<Equipo> equipos) {
		for(Equipo equipo:equipos) {
			System.out.println(equipo);
			List<Jugador> jugadores=equipo.getJugadores();
			Iterator<Jugador> iterator=jugadores.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}
	public boolean borrarEquipo(int idEquipo) {
		boolean exito=true;
		//Extraer de la base de datos el equipo con id=idEquipo
		try {
			Equipo equipo= em.find(Equipo.class, idEquipo);
			
			//Extraer de la base de datos el equipo JugadoresMercadoDivision, donde division es la del equipo a borrar
			String jpql="select e from Equipo e where e.nombre=?1";
			Query query= em.createQuery(jpql);
			query.setParameter(1, "JugadoresMercado"+Character.toUpperCase(equipo.getDivision().charAt(0))+equipo.getDivision().substring(1,equipo.getDivision().length()-1));
			//En el equipo equipoagentesLibres se almacenan los jugadores del equipo que vamos a eliminar
			Equipo equipoAgentesLibres= (Equipo) query.getSingleResult();
			
			List<Jugador> jugadores =equipo.getJugadores();
			// Cada jugador del equipo se traspasa al EquipoAgentesLibres
			for(Jugador jugador:jugadores) {
				traspaso(equipo.getId(),equipoAgentesLibres.getId(),jugador);
			}
			//El equipo que queremos borrar tiene 0 jugadores
			EntityTransaction tran= em.getTransaction();
			tran.begin();
			em.remove(equipo);
			tran.commit();
		} catch (Exception e) {
			exito=false;
		}
		return exito;
	}
}
