package org.solid.domain.miseenoeuvre;

import org.solid.domain.machine.DescriptionMachines;
import org.solid.domain.machine.MachineACafe;
import org.solid.domain.machine.GererStock;
import org.solid.domain.machine.MachineACafeImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ParcMachineACafe {
    private final Map<String, MachineACafeImpl> lesMachinesACafe = new HashMap<>();


    public void addMachine(MachineACafeImpl machineACafe) {
        lesMachinesACafe.put(machineACafe.getNom(), machineACafe);
    }

    public List<DescriptionMachines> listesMachines() {
        return lesMachinesACafe.values().stream().map(MachineACafeImpl::description).toList();
    }

    public Optional<MachineACafe> trouveMachinePourConsomation(String nomMachine) {
        return Optional.ofNullable(lesMachinesACafe.get(nomMachine));
    }

    public Optional<GererStock> trouveMachinePourMaintenance(String nomMachine) {
        return Optional.ofNullable(lesMachinesACafe.get(nomMachine));
    }
}
