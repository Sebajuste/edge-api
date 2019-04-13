package io.edge.api.dao;

import io.vertx.core.json.JsonObject;

public interface DaoFactory {

	public Dao<JsonObject> getJsonObjectDao(String collection);

}
