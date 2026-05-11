package dev.alexandraemmeline.EventClean.Infrastructure.Controllers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.UseCases.BuscarEventoUseCase;
import dev.alexandraemmeline.EventClean.Core.UseCases.CriarEventoUseCase;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoDTOMapper eventoDTOMapper;
    private final CriarEventoUseCase criarEventoUseCase;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventoDTO criar(@RequestBody EventoDTO eventoDTO) {

        EventoDomain novoEvento = criarEventoUseCase.execute(eventoDTOMapper.toDomain(eventoDTO));

        return eventoDTOMapper.toDTO(novoEvento);
    }

/*
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventoDTO> buscar(@PathVariable Integer id) {

        EventoDTO evento = eventoMapper.toDTO(buscarEventoUseCase.execute(id));

        return
    }
*/

}
