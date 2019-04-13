package io.edge.api.verticle;

import org.apache.log4j.Logger;

import io.edge.api.rest.ApiRest;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class ApiVerticle extends AbstractVerticle {

	private static final Logger LOGGER = Logger.getLogger(ApiVerticle.class);

	@Override
	public void start(Future<Void> startFuture) {

		Router router = Router.router(vertx);

		router.route().handler(BodyHandler.create());

		ApiRest apiRest = new ApiRest();

		router.get("/api/:collection").handler(apiRest::getAll);
		router.get("/api/:collection/:id").handler(apiRest::findById);
		router.post("/api/:collection").handler(apiRest::create);
		router.patch("/api/:collection/:id").handler(apiRest::update);
		router.delete("/api/:collection/:id").handler(apiRest::delete);

		HttpServerOptions httpServerOption = new HttpServerOptions();

		HttpServer httpServer = vertx.createHttpServer(httpServerOption);

		httpServer.requestHandler(router).listen(listenResult -> {

			if (listenResult.succeeded()) {
				LOGGER.debug("Start on port : " + listenResult.result().actualPort());
				startFuture.complete();
			} else {
				LOGGER.error("Cannot start HTTP app");
				startFuture.fail("Cannot start HTTP server");
			}

		});

	}

}
