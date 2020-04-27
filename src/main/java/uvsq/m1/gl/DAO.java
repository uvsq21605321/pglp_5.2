package uvsq.m1.gl;

public interface DAO<T> {
		
	
	T create(T obj);
	T read(String id);
	T update(T obj);
	void delete(T obj);

}
