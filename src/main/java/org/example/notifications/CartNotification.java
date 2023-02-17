package org.example.notifications;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class CartNotification {

  private final Sinks.Many<Integer> cartSink = Sinks.many().multicast().onBackpressureBuffer();

  public void send(Integer id){
      cartSink.tryEmitNext(id);
  }

  public Flux<Integer> getCartNotificationsFlux(){
      return cartSink.asFlux();
  }

}
