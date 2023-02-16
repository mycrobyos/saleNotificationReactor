package org.example.notifications;


import org.example.model.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SaleNotification {

    private final Sinks.Many<Sale> saleSink = Sinks.many().multicast().onBackpressureBuffer();

    public void send(Sale sale){
        saleSink.tryEmitNext(sale);
    }

    public Flux<Sale> getVendaFlux(){
        return saleSink.asFlux();
    }

}
