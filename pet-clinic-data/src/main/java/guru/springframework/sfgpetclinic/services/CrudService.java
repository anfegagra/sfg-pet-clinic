package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

	Set<T> findAll();

	T findById(ID h);

	T save(T object);

	void delete(T object);

	void deleteById(ID id);

}
