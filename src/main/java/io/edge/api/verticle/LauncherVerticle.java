package io.edge.api.verticle;

import io.vertx.core.AbstractVerticle;

public class LauncherVerticle extends AbstractVerticle {

	@Override
	public void start() {

		vertx.deployVerticle(ProxyVerticle.class.getName());

	}

}
