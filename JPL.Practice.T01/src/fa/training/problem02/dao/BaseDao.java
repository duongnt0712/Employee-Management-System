package fa.training.problem02.dao;

public interface BaseDao<T,K> {
	int create(T model);
}
