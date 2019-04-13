package io.edge.api.dao.mongo;

import java.util.List;

import io.edge.api.dao.Dao;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.mongo.UpdateOptions;

public class MongoDao implements Dao<JsonObject> {

	private final MongoClient mongo;

	private final String collection;

	public MongoDao(MongoClient mongo, String collection) {
		super();
		this.mongo = mongo;
		this.collection = collection;
	}

	@Override
	public <T> void findById(T id, Handler<AsyncResult<JsonObject>> resultHandler) {
		this.mongo.findOne(collection, new JsonObject().put("_id", id), null, resultHandler);
	}

	@Override
	public void getAll(Handler<AsyncResult<List<JsonObject>>> resultHandler) {
		this.mongo.find(collection, new JsonObject(), resultHandler);
	}

	@Override
	public void create(JsonObject document, Handler<AsyncResult<Boolean>> resultHandler) {
		this.mongo.insert(collection, document, insertResult -> {
			if (insertResult.succeeded()) {
				resultHandler.handle(Future.succeededFuture(insertResult.result() != null));
			} else {
				resultHandler.handle(Future.failedFuture(insertResult.cause()));
			}
		});
	}

	@Override
	public void update(JsonObject obj, JsonObject update, Handler<AsyncResult<Boolean>> resultHandler) {

		this.mongo.updateCollection(collection, obj, update, updateResult -> {
			if (updateResult.succeeded()) {
				resultHandler.handle(Future.succeededFuture(updateResult.result().getDocModified() > 0));
			} else {
				resultHandler.handle(Future.failedFuture(updateResult.cause()));
			}
		});
	}

	public void createOrUpdate(JsonObject obj, JsonObject update, Handler<AsyncResult<Boolean>> resultHandler) {

		UpdateOptions options = new UpdateOptions();
		options.setUpsert(true);

		this.mongo.updateCollectionWithOptions(collection, obj, update, options, updateResult -> {

			if (updateResult.succeeded()) {
				resultHandler.handle(Future.succeededFuture(updateResult.result().getDocModified() > 0));
			} else {
				resultHandler.handle(Future.failedFuture(updateResult.cause()));
			}

		});

	}

	@Override
	public void delete(JsonObject obj, Handler<AsyncResult<Boolean>> resultHandler) {
		this.mongo.removeDocument(collection, obj, removeResult -> {
			if (removeResult.succeeded()) {
				resultHandler.handle(Future.succeededFuture(removeResult.result().getRemovedCount() > 0));
			} else {
				resultHandler.handle(Future.failedFuture(removeResult.cause()));
			}
		});
	}

}
