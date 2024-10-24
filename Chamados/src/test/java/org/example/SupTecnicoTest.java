package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SupTecnicoTest {
    @Test
    void deveNotificarUmTecnico() {
        Chamado chamado = new Chamado(1, "Problema com impressora", "Alta");
        SupTecnico tecnico = new SupTecnico("Tecnico 1");
        tecnico.atenderChamado(chamado);
        chamado.atualizarStatus("Em Andamento");
        assertEquals("Tecnico 1, novo chamado registrado: Chamado{numero=1, descricao='Problema com impressora', status='Em Andamento', prioridade='Alta'}",
                tecnico.getUltimoChamado());
    }

    @Test
    void deveNotificarTecnicos() {
        Chamado chamado = new Chamado(1, "Problema com impressora", "Alta");
        SupTecnico tecnico1 = new SupTecnico("Tecnico 1");
        SupTecnico tecnico2 = new SupTecnico("Tecnico 2");
        tecnico1.atenderChamado(chamado);
        tecnico2.atenderChamado(chamado);
        chamado.atualizarStatus("Em Andamento");
        assertEquals("Tecnico 1, novo chamado registrado: Chamado{numero=1, descricao='Problema com impressora', status='Em Andamento', prioridade='Alta'}",
                tecnico1.getUltimoChamado());
        assertEquals("Tecnico 2, novo chamado registrado: Chamado{numero=1, descricao='Problema com impressora', status='Em Andamento', prioridade='Alta'}",
                tecnico2.getUltimoChamado());
    }

    @Test
    void naoDeveNotificarTecnico() {
        Chamado chamado = new Chamado(1, "Problema com impressora", "Alta");
        SupTecnico tecnico = new SupTecnico("Tecnico 1");
        chamado.atualizarStatus("Em Andamento");
        assertNull(tecnico.getUltimoChamado());
    }

    @Test
    void deveNotificarTecnicoDoChamadoA() {
        Chamado chamadoA = new Chamado(1, "Problema com impressora", "Alta");
        Chamado chamadoB = new Chamado(2, "Problema com rede", "Media");
        SupTecnico tecnico1 = new SupTecnico("Tecnico 1");
        SupTecnico tecnico2 = new SupTecnico("Tecnico 2");
        tecnico1.atenderChamado(chamadoA);
        tecnico2.atenderChamado(chamadoB);
        chamadoA.atualizarStatus("Em Andamento");
        assertEquals("Tecnico 1, novo chamado registrado: Chamado{numero=1, descricao='Problema com impressora', status='Em Andamento', prioridade='Alta'}",
                tecnico1.getUltimoChamado());
        assertNull(tecnico2.getUltimoChamado());
    }
}