package io.edge.api.rest;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class ApiRest {

	public void getAll(RoutingContext context) {

		String collection = context.pathParam("collection");

	}

	public void findById(RoutingContext context) {

		String collection = context.pathParam("collection");

		String id = context.pathParam("id");

	}

	public void create(RoutingContext context) {

		String collection = context.pathParam("collection");

		JsonObject objet = context.getBodyAsJson();

	}

	public void update(RoutingContext context) {

		String collection = context.pathParam("collection");

		String id = context.pathParam("id");

		JsonObject objet = context.getBodyAsJson();

	}

	public void delete(RoutingContext context) {

		String collection = context.pathParam("collection");

		String id = context.pathParam("id");

	}

}
