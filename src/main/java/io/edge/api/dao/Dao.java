package io.edge.api.dao;

import java.util.List;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public interface Dao<T> {

	<K> void findById(K id, Handler<AsyncResult<T>> resultHandler);

	void getAll(Handler<AsyncResult<List<T>>> resultHandler);

	void create(T obj, Handler<AsyncResult<Boolean>> resultHandler);

	void update(T obj, T updated, Handler<AsyncResult<Boolean>> resultHandler);

	void delete(T obj, Handler<AsyncResult<Boolean>> resultHandler);

}
