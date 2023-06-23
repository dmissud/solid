package org.solid.domain.miseenoeuvre;


import org.solid.domain.machine.MachineACafe;
import org.solid.domain.usage.Client;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class Clientele {
    private final Map<String, Client> lesClients = new HashMap<>();

    public void addClient(Client client) {
        lesClients.put(client.getNom(), client);
    }

    public Optional<Client> trouveClient(String nomClient) {
        return Optional.ofNullable(lesClients.get(nomClient));
    }

    public void clear() {
        lesClients.clear();
    }

    public List<String> listesClients() {
        return lesClients.keySet().stream().toList();
    }

    public void consommerTous(MachineACafe machineACafe) {
        lesClients.values().forEach(client -> client.consommer(machineACafe));
    }

    public String satisfaction() {
        return lesClients.values().stream().map(client -> client.getNom() + " : " + client.estSatisfait() + "\n").toList().toString();
    }
}
