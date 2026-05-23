package dev.alexandraemmeline.EventClean.Infrastructure.Controllers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.UseCases.*;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import dev.alexandraemmeline.EventClean.Infrastructure.Handler.SucessResponse;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


    @PostMapping
    public ResponseEntity<SucessResponse<EventoDTO>> criar(@RequestBody EventoDTO eventoDTO) {

        EventoDomain novoEventoDomain = criarEventoUseCase.execute(eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO novoEventoDTO = eventoDTOMapper.toDTO(novoEventoDomain);

        SucessResponse<EventoDTO> response= new SucessResponse<>(
                true,
                "Evento criado com sucesso",
                novoEventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SucessResponse<EventoDTO>> buscar(@PathVariable Long id) {

        EventoDomain eventoDomain = buscarEventoUseCase.execute(id);

        EventoDTO eventoDTO = eventoDTOMapper.toDTO(eventoDomain);

        SucessResponse<EventoDTO> response = new SucessResponse<>(
                true,
                "Evento encontrado!",
                eventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }


    @GetMapping
    public ResponseEntity<SucessResponse<List<EventoDTO>>> listar() {

        List<EventoDTO> eventosDTO = listarEventosUseCase.execute()
                .stream()
                .map(eventoDTOMapper::toDTO)
                .toList();

        SucessResponse<List<EventoDTO>> response = new SucessResponse<>(
                true,
                "Consulta realizada com sucesso",
                eventosDTO,
                LocalDateTime.now()
        );


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SucessResponse<Void>> deletar(@PathVariable Long id) {

        deletarEventoUseCase.execute(id);

        SucessResponse<Void> response = new SucessResponse<>(
                true,
                "Evento deletado com sucesso",
                null,
                LocalDateTime.now()
        );


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SucessResponse<EventoDTO>> atualizar(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {

        EventoDomain eventoAtualizado = atualizarEventoUseCase.execute(id, eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO eventoAtualizadoDTO = eventoDTOMapper.toDTO(eventoAtualizado);

        SucessResponse<EventoDTO> response = new SucessResponse<>(
                true,
                "Evento atualizado com sucesso!",
                eventoAtualizadoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<SucessResponse<EventoDTO>> atualizarParcialmente(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {

        EventoDomain eventoAtualizado = atualizarEventoParcialmenteUseCase.execute(id, eventoDTOMapper.toDomain(eventoDTO));

        SucessResponse<EventoDTO> response = new SucessResponse<>(
                true,
                "Evento atualizado com sucesso!",
                eventoDTO,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }


}
