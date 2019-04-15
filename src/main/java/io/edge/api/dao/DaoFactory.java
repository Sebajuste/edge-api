package io.edge.api.dao;

import io.vertx.core.json.JsonObject;

public interface DaoFactory {

	Dao<JsonObject> getJsonObjectDao(String collection);

}
