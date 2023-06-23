package org.solid.domain.miseenoeuvre;


import org.solid.domain.machine.MachineACafe;
import org.solid.domain.usage.AgentDeMaintenance;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class Maintenance {
    private final Map<String, AgentDeMaintenance> lesAgents = new HashMap<>();

    public void addAgentDeMaintenance(AgentDeMaintenance agentDeMaintenance) {
        lesAgents.put(agentDeMaintenance.getNom(), agentDeMaintenance);
    }

    public Optional<AgentDeMaintenance> trouveAgent(String nomAgent) {
        return Optional.ofNullable(lesAgents.get(nomAgent));
    }

    public List<String> listesAgents() {
        return lesAgents.keySet().stream().toList();
    }

    public void maintenance(String nom, MachineACafe machineACafe) {
        trouveAgent(nom).ifPresent(agentDeMaintenance -> agentDeMaintenance.ajusterLeStock(machineACafe));
    }
}
