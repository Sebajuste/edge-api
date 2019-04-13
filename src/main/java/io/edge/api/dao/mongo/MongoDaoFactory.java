package io.edge.api.dao.mongo;

import io.edge.api.dao.Dao;
import io.edge.api.dao.DaoFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

public class MongoDaoFactory implements DaoFactory {

	private final MongoClient mongo;

	public MongoDaoFactory(MongoClient mongo) {
		super();
		this.mongo = mongo;
	}

	@Override
	public Dao<JsonObject> getJsonObjectDao(String collection) {
		return new MongoDao(mongo, collection);
	}

}
