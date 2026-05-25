package dev.alexandraemmeline.EventClean.Infrastructure.Controllers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.UseCases.*;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import dev.alexandraemmeline.EventClean.Infrastructure.Handler.SuccessResponse;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoDTOMapper eventoDTOMapper;
    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final ListarEventosUseCase listarEventosUseCase;
    private final DeletarEventoUseCase deletarEventoUseCase;
    private final AtualizarEventoUseCase atualizarEventoUseCase;
    private final AtualizarEventoParcialmenteUseCase atualizarEventoParcialmenteUseCase;
    private final BuscarEventoPorIdentificadorUseCase buscarEventoPorIdentificadorUseCase;


    @PostMapping
    public ResponseEntity<SuccessResponse<EventoDTO>> criar(@RequestBody EventoDTO eventoDTO) {

        EventoDomain novoEventoDomain = criarEventoUseCase.execute(eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO novoEventoDTO = eventoDTOMapper.toDTO(novoEventoDomain);

        SuccessResponse<EventoDTO> response= new SuccessResponse<>(
                true,
                "Evento criado com sucesso",
                novoEventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<EventoDTO>> buscar(@PathVariable Long id) {

        EventoDomain eventoDomain = buscarEventoUseCase.execute(id);

        EventoDTO eventoDTO = eventoDTOMapper.toDTO(eventoDomain);

        SuccessResponse<EventoDTO> response = new SuccessResponse<>(
                true,
                "Evento encontrado!",
                eventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }


    @GetMapping
    public ResponseEntity<SuccessResponse<List<EventoDTO>>> listar() {

        List<EventoDTO> eventosDTO = listarEventosUseCase.execute()
                .stream()
                .map(eventoDTOMapper::toDTO)
                .toList();

        SuccessResponse<List<EventoDTO>> response = new SuccessResponse<>(
                true,
                "Consulta realizada com sucesso",
                eventosDTO,
                LocalDateTime.now()
        );


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Void>> deletar(@PathVariable Long id) {

        deletarEventoUseCase.execute(id);

        SuccessResponse<Void> response = new SuccessResponse<>(
                true,
                "Evento deletado com sucesso",
                null,
                LocalDateTime.now()
        );


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<EventoDTO>> atualizar(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {

        EventoDomain eventoAtualizado = atualizarEventoUseCase.execute(id, eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO eventoAtualizadoDTO = eventoDTOMapper.toDTO(eventoAtualizado);

        SuccessResponse<EventoDTO> response = new SuccessResponse<>(
                true,
                "Evento atualizado com sucesso!",
                eventoAtualizadoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<SuccessResponse<EventoDTO>> atualizarParcialmente(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {

        EventoDomain eventoAtualizado = atualizarEventoParcialmenteUseCase.execute(id, eventoDTOMapper.toDomain(eventoDTO));

        SuccessResponse<EventoDTO> response = new SuccessResponse<>(
                true,
                "Evento atualizado com sucesso!",
                eventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }


    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<SuccessResponse<EventoDTO>> buscarPorIdentificador(@PathVariable String identificador) {

        EventoDomain evento = buscarEventoPorIdentificadorUseCase.execute(identificador);

        EventoDTO eventoDTO = eventoDTOMapper.toDTO(evento);

        SuccessResponse<EventoDTO> response = new SuccessResponse<>(
                true,
                "Evento encontrado!",
                eventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


}
