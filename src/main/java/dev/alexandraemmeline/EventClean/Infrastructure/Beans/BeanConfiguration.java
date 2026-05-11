package dev.alexandraemmeline.EventClean.Infrastructure.Beans;

import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;
import dev.alexandraemmeline.EventClean.Core.UseCases.CriarEventoUseCase;
import dev.alexandraemmeline.EventClean.Core.UseCases.CriarEventoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new CriarEventoUseCaseImpl(eventoRepositoryGateway);
    }

}
