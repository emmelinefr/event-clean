package dev.alexandraemmeline.EventClean.Infrastructure.Controllers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.UseCases.*;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    public ResponseEntity<Map<String, Object>> criar(@RequestBody EventoDTO eventoDTO) {

        EventoDomain novoEventoDomain = criarEventoUseCase.execute(eventoDTOMapper.toDomain(eventoDTO));

        EventoDTO novoEventoDTO = eventoDTOMapper.toDTO(novoEventoDomain);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "Evento cadastrado com sucesso!");
        response.put("data", novoEventoDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Long id) {

        EventoDomain eventoDomain = buscarEventoUseCase.execute(id);

        Map<String, Object> response = new LinkedHashMap<>();

        if (eventoDomain == null) {
            response.put("success", false);
            response.put("message", "Evento não encontrado!");
            response.put("status", 404);

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        EventoDTO eventoDTO = eventoDTOMapper.toDTO(eventoDomain);

        response.put("success", true);
        response.put("message", "Evento encontrado!");
        response.put("data", eventoDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> listar() {

        List<EventoDTO> eventosDTO = listarEventosUseCase.execute()
                .stream()
                .map(eventoDTOMapper::toDTO)
                .toList();

        Map<String, Object> response = new LinkedHashMap<>();

        if (eventosDTO.isEmpty()) {
            response.put("success", true);
            response.put("message", "Nenhum evento cadastrado!");
            response.put("data", eventosDTO);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }

        response.put("success", true);
        response.put("message", "Eventos encontrados!");
        response.put("data", eventosDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {

        deletarEventoUseCase.execute(id);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "Evento deletado com sucesso!");


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {

        EventoDomain eventoAtualizado = atualizarEventoUseCase.execute(id, eventoDTOMapper.toDomain(eventoDTO));

        Map<String, Object> response = new LinkedHashMap<>();

        if (eventoAtualizado == null) {
            response.put("success", false);
            response.put("message", "Evento não encontrado!");
            response.put("status", 404);

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        response.put("success", true);
        response.put("message", "Evento atualizado com sucesso!");
        response.put("data", eventoDTOMapper.toDTO(eventoAtualizado));

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
