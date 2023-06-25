package org.solid.cmd;

import org.solid.domain.machine.GererStock;
import org.solid.domain.miseenoeuvre.Maintenance;
import org.solid.domain.miseenoeuvre.ParcMachineACafe;
import org.solid.domain.usage.AgentDeMaintenance;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
@ShellCommandGroup("La maintenance")
public class GestionDeLaMaintenance {
    private final Maintenance maintenance;
    private final ParcMachineACafe parcMachineACafe;

    public GestionDeLaMaintenance(Maintenance maintenance, ParcMachineACafe parcMachineACafe) {
        this.maintenance = maintenance;
        this.parcMachineACafe = parcMachineACafe;
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

    @ShellMethod(value = "Maintenance d'une machine", key = "maintenance")
    public void maintenance(String nomAgent, String nomMachine) {
        Optional<GererStock> machineACafe = parcMachineACafe.trouveMachinePourMaintenance(nomMachine);
        machineACafe.ifPresent(machine -> maintenance.maintenance(nomAgent, machine));
    }

}
