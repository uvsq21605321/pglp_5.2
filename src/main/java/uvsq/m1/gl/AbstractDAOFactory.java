package uvsq.m1.gl;

public abstract class AbstractDAOFactory {
	public enum DAOType {JDBC, Serial};
	
	public abstract DAO<Personnel> getPersonnelDAO();
	
	public abstract DAO<Groupe> getPersonnelGroupeDAO();
	
	public static AbstractDAOFactory getFactory(DAOType type) {
		if (type == DAOType.JDBC) return new JdbcDAOFactory();
		return null;
	}
	
}
