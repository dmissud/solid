package org.solid.cmd;

import org.solid.domain.miseenoeuvre.Maintenance;
import org.solid.domain.usage.AgentDeMaintenance;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("La maintenance")
public class GestionDeLaMaintenance {
    private final Maintenance maintenance;

    public GestionDeLaMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    @ShellMethod(value = "Créer un Agent de Maintenance", key = "creerAgent")
    public String creerAgentDemaintenance(String nomAgent) {
        maintenance.addAgentDeMaintenance(new AgentDeMaintenance(nomAgent));
        return "agent créé";
    }

    @ShellMethod(value = "Lister les agent de maintenance", key = "listerAgents")
    public String listerAgentsDeMaintenance() {
        return maintenance.listesAgents().toString();
    }

}
