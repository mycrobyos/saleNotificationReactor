package org.example.notifications;

import org.example.model.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class CartNotification {

  private final Sinks.Many<Integer> cartSink = Sinks.many().multicast().onBackpressureBuffer();

  public void send(Integer id){
      saleSink.tryEmitNext(id);
  }

  public Flux<Integer> getCartFlux(){
      return cartSink.asFlux();
  }

}
