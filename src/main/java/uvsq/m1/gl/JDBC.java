package uvsq.m1.gl;

import uvsq.m1.gl.AbstractDAOFactory.DAOType;
import uvsq.m1.gl.Personnel.PersonnelBuilder;
public enum JDBC {
	ENVIRONNEMENT;
	
	private void run(String[] args, DAOType dt) {
		DAO<Personnel> personnelDAO = AbstractDAOFactory
				.getFactory(dt) // Factory
				.getPersonnelDAO();
		DAO<Groupe> pgDAO = AbstractDAOFactory
				.getFactory(dt)
				.getPersonnelGroupeDAO();
		// Creation personnel
		Personnel per1 = new PersonnelBuilder("ELmchichi", "Maryeme", "Employe")
				   			.build();
		Personnel per2 = new PersonnelBuilder("Bensouda", "Laila", "Employe")
							.build();
		Groupe pg = new Groupe();
		Groupe spg = new Groupe();
		pg.addPersonnel(spg);
		pg.addPersonnel(per2);
		spg.addPersonnel(per1);
		// Ajout DAO
		pgDAO.create(pg);
		pgDAO.create(spg);
		personnelDAO.create(per1); // mise à jour
		personnelDAO.create(per2); // mise à jour
		System.out.println("\t" + pgDAO.read(spg.getId()));
		System.out.println("\t" + personnelDAO.read("personne numéro 2"));
	}
	
	public static void main(String[] args) {
		JdbcInitializer jinit = new JdbcInitializer();
		// pour la premiÃ¨re fois on utilise jinit.createTables() pour creer les tables
		jinit.createTables();
		//jinit.dropCreateTables(); 
		
		ENVIRONNEMENT.run(args, DAOType.JDBC);
	}
}
