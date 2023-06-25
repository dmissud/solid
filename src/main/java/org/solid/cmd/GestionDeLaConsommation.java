package org.solid.cmd;


import org.solid.domain.machine.MachineACafe;
import org.solid.domain.machine.GererStock;
import org.solid.domain.miseenoeuvre.Clientele;
import org.solid.domain.miseenoeuvre.Maintenance;
import org.solid.domain.miseenoeuvre.ParcMachineACafe;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
@ShellCommandGroup("GestionDeLaConsommation de café")
public class GestionDeLaConsommation {
    public static final String AUCUNE_MACHINE_NE_CORRESPOND_A_CE_NOM = "Aucune machine ne correspond à ce nom";
    private final ParcMachineACafe parcMachineACafe;
    private final Clientele clientele;
    private final Maintenance maintenance;

    public GestionDeLaConsommation(ParcMachineACafe parcMachineACafe, Clientele clientele, Maintenance maintenance) {
        this.parcMachineACafe = parcMachineACafe;
        this.clientele = clientele;
        this.maintenance = maintenance;
    }

    @ShellMethod(value = "Consommation d'un café.", key = "acheter")
    public String consommer(String nomClient, String nomMachine) {
        Optional<MachineACafe> machineACafe = parcMachineACafe.trouveMachinePourConsomation(nomMachine);
        if (machineACafe.isEmpty()) {
            return AUCUNE_MACHINE_NE_CORRESPOND_A_CE_NOM;
        }
        clientele.trouveClient(nomClient).ifPresent(client -> client.consommer(machineACafe.get()));
        return nomClient + " a consommé un café";
    }

    @ShellMethod(value = "Consommation d'un café par tous les clients", key = "tous")
    public String consommerTous(String nomMachine) {
        Optional<MachineACafe> machineACafe = parcMachineACafe.trouveMachinePourConsomation(nomMachine);
        if (machineACafe.isEmpty()) {
            return AUCUNE_MACHINE_NE_CORRESPOND_A_CE_NOM;
        }
        clientele.consommerTous(machineACafe.get());
        return "Consommation de café par tous les clients sur "+ nomMachine;
    }

    @ShellMethod(value = "Scenario de test", key = "scenario1")
    public String scenarioUn(int boucle, int cycle) {
        StringBuilder execution = new StringBuilder();
        while (cycle > 0) {
            int doBoucle = boucle;
            while (doBoucle > 0) {
                execution.append(consommer("Jean", "Basic1")).append("\n");
                execution.append(consommer("Paul", "Basic2")).append("\n");
                execution.append(consommer("Jacques", "Premium")).append("\n");
                execution.append(consommer("Jacques", "Premium")).append("\n");
                execution.append(consommer("Jacques", "Premium")).append("\n");
                execution.append(consommerTous("Basic1")).append("\n");
                execution.append(consommerTous("Basic2")).append("\n");
                execution.append(consommerTous("Basic1")).append("\n");
                execution.append(consommerTous("Basic2")).append("\n");
                execution.append(consommerTous("Premium")).append("\n");
                doBoucle--;
            }
            cycle--;
            final String[] message = {"Stock des machines : \n"};
            parcMachineACafe.listesMachines().forEach(descriptionMachines ->
                    message[0] = message[0] + descriptionMachines.nom() + ":" + descriptionMachines.stock() + "\n"
            );
            execution.append(message[0]).append("\n");
            maintenance("Arthur", "Basic1");
            execution.append("Maintenance Réalisée").append("\n");
        }
        execution.append("Satisfaction des clients : \n").append(clientele.satisfaction()).append("\n");
        return execution.toString();
    }

    private void maintenance(String nomAgent, String nomMachine) {
        Optional<GererStock> machineACafeGererStock = parcMachineACafe.trouveMachinePourMaintenance(nomMachine);
        machineACafeGererStock.ifPresent(machine -> maintenance.maintenance(nomAgent, machine));
    }

}
