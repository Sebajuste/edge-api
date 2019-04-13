package io.edge.api.dao;

import java.util.List;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public interface Dao<T> {

	public <K> void findById(K id, Handler<AsyncResult<T>> resultHandler);

	public void getAll(Handler<AsyncResult<List<T>>> resultHandler);

	public void create(T obj, Handler<AsyncResult<Boolean>> resultHandler);

	public void update(T obj, T updated, Handler<AsyncResult<Boolean>> resultHandler);

	public void delete(T obj, Handler<AsyncResult<Boolean>> resultHandler);

}
