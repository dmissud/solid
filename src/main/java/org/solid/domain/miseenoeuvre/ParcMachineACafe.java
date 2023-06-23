package org.solid.domain.miseenoeuvre;

import org.solid.domain.machine.DescriptionMachines;
import org.solid.domain.machine.MachineACafe;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ParcMachineACafe {
    private final Map<String, MachineACafe> lesMachinesACafe = new HashMap<>();


    public void addMachine(MachineACafe machineACafe) {
        lesMachinesACafe.put(machineACafe.getNom(), machineACafe);
    }

    public List<DescriptionMachines> listesMachines() {
        return lesMachinesACafe.values().stream().map(MachineACafe::description).toList();
    }

    public Optional<MachineACafe> trouveMachine(String nomMachine) {
        return Optional.ofNullable(lesMachinesACafe.get(nomMachine));
    }
}
