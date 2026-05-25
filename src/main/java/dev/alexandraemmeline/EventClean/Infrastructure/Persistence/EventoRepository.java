package dev.alexandraemmeline.EventClean.Infrastructure.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface EventoRepository extends JpaRepository<EventoEntity, Long> {

    Optional<EventoEntity> findByIdentificadorIgnoreCase(String identificador);


    //treinando native query
    @Query(
            value = """
                    SELECT EXISTS(
                    SELECT 1
                    FROM eventos
                    WHERE LOWER(identificador) = LOWER(:identificador))
                    """,
                    nativeQuery = true)

    boolean existePorIdentificador(@Param("identificador") String identificador);
}
