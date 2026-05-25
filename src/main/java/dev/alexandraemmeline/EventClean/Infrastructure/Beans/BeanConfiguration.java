package dev.alexandraemmeline.EventClean.Infrastructure.Beans;

import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;
import dev.alexandraemmeline.EventClean.Core.UseCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new CriarEventoUseCaseImpl(eventoRepositoryGateway);
    }


    @Bean
    public BuscarEventoUseCase buscarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new BuscarEventoUseCaseImpl(eventoRepositoryGateway);
    }


    @Bean
    public ListarEventosUseCase listarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new ListarEventosUseCaseImpl(eventoRepositoryGateway);
    }

    @Bean
    public DeletarEventoUseCase deletarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new DeletarEventoUseCaseImpl(eventoRepositoryGateway);
    }

    @Bean
    public AtualizarEventoUseCase atualizarEventoUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new AtualizarEventoUseCaseImpl(eventoRepositoryGateway);
    }

    @Bean
    public AtualizarEventoParcialmenteUseCase atualizarEventoParcialmenteUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new AtualizarEventoParcialmenteUseCaseImpl(eventoRepositoryGateway);
    }

    @Bean
    public BuscarEventoPorIdentificadorUseCase buscarEventoPorIdentificadorUseCase(EventoRepositoryGateway eventoRepositoryGateway) {
        return new BuscarEventoPorIdentificadorUseCaseImpl(eventoRepositoryGateway);
    }

}
