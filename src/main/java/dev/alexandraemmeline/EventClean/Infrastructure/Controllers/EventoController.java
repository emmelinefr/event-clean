package dev.alexandraemmeline.EventClean.Infrastructure.Controllers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.UseCases.BuscarEventoUseCase;
import dev.alexandraemmeline.EventClean.Core.UseCases.CriarEventoUseCase;
import dev.alexandraemmeline.EventClean.Core.UseCases.ListarEventosUseCase;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoDTOMapper;
import dev.alexandraemmeline.EventClean.Infrastructure.Persistence.EventoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoDTOMapper eventoDTOMapper;
    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final ListarEventosUseCase listarEventosUseCase;


    @PostMapping
    public ResponseEntity<EventoDTO> criar(@RequestBody EventoDTO eventoDTO) {

        EventoDomain novoEventoDomain = criarEventoUseCase.execute(eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO novoEventoDTO = eventoDTOMapper.toDTO(novoEventoDomain);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> buscar(@PathVariable Long id) {

        EventoDomain eventoDomain = buscarEventoUseCase.execute(id);

        if (eventoDomain == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EventoDTO eventoDTO = eventoDTOMapper.toDTO(eventoDomain);

        return ResponseEntity.status(HttpStatus.OK)
                .body(eventoDTO);

    }


    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar() {

        List<EventoDTO> eventosDTO = listarEventosUseCase.execute()
                .stream()
                .map(eventoDTOMapper::toDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(eventosDTO);
    }

}
