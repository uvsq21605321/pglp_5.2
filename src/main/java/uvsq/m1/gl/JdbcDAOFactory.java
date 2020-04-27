package uvsq.m1.gl;

public class JdbcDAOFactory extends AbstractDAOFactory {

	@Override
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelJdbcDAO();
	}

	@Override
	public DAO<Groupe> getPersonnelGroupeDAO() {
		return new GroupeJdbcDAO();
	}

}
