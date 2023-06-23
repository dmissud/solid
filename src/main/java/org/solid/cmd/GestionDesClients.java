package org.solid.cmd;


import org.solid.domain.miseenoeuvre.Clientele;
import org.solid.domain.usage.Client;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("Les clients")
public class GestionDesClients {
    private final Clientele clientele;

    public GestionDesClients(Clientele clientele) {
        this.clientele = clientele;
    }

    @ShellMethod(value = "Créer un client", key = "creerClient")
    public String creerClient(String nomClient, int sucre, boolean avecLait) {
        clientele.addClient(new Client(nomClient, sucre, avecLait));
        return "Client créé";
    }

    @ShellMethod(value = "Lister les clients", key = "listerClients")
    public String listerClients() {
        return clientele.listesClients().toString();
    }

    @ShellMethod(value = "Satisfactions des clients", key = "satisfaction")
    public String satisfaction() {
        return clientele.satisfaction();
    }

    @ShellMethod(value = "Initialiser les clients", key = "initClients")
    public String initialiserClients() {
        clientele.clear();
        clientele.addClient(new Client("Jean", 1, false));
        clientele.addClient(new Client("Paul", 5, false));
        clientele.addClient(new Client("Jacques", 0, true));
        clientele.addClient(new Client("Pierre", 11, true));
        clientele.addClient(new Client("André", 2, false));
        clientele.addClient(new Client("Jeanne", 5, true));
        clientele.addClient(new Client("Marie", 8, false));
        clientele.addClient(new Client("Julie", 0, true));
        return "Clients initialisés";
    }
}
