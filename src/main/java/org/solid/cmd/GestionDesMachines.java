package org.solid.cmd;

import org.solid.domain.machine.MachineACafeImpl;
import org.solid.domain.miseenoeuvre.ParcMachineACafe;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("Parc de machine à café")
public class GestionDesMachines {
    private final ParcMachineACafe parcMachineACafe;

    public GestionDesMachines(ParcMachineACafe parcMachineACafe) {
        this.parcMachineACafe = parcMachineACafe;
    }

    public static final String SEPARATOR_LINE = "-------------------------------------------------\n";


    @ShellMethod(value = "Initialise le parc de machine.", key = "initMachine")
    public String initialisationDuParc() {
        parcMachineACafe.addMachine(new MachineACafeImpl("Basic1"));
        return buildMessage();
    }

    @ShellMethod(value = "Ajout d'une machine Basic au parc de machine.", key = "basic")
    public String nouvelleMachineBasic(String nomMachine) {
        parcMachineACafe.addMachine(new MachineACafeImpl(nomMachine));
        return buildMessage();
    }


    @ShellMethod(value = "Stock des machines.", key = "stock")
    public String stockDesMachines() {
        final String[] message = {SEPARATOR_LINE + "Stock des machines : \n"};
        parcMachineACafe.listesMachines().forEach(descriptionMachines ->
                message[0] = message[0] + descriptionMachines.nom() + ":" + descriptionMachines.stock() + "\n"
        );
        return message[0] + SEPARATOR_LINE;
    }

    private String buildMessage() {
        final String[] message = {SEPARATOR_LINE + "Description du parc de machine : \n"};
        parcMachineACafe.listesMachines().forEach(descriptionMachines ->
                message[0] = message[0] + descriptionMachines.nom() + "\n"
        );
        return message[0] + SEPARATOR_LINE;
    }
}



