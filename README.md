# Le principe de Substitution de Liskov

Les sous-types doivent être subtituables à leur type de base





# Les Machines A café

Exemple pour illustrer les principes LSR et ISP



Une Machine à cafe doit être capable de

- Preparer un cafe avec

    - une quantité de sucre allant de 0 à 10

    - du lait ou non

- Permettre de la reaprovisioner en café, sucre et lait

- Donner l'état de son stock de café, sucre et lait



Un Client doit pouvoir commander un café en indiquant son choix en quantité de sucre et si il veut du lait ou non

l'agent de maintenance doit pouvoir connaître le stock de café, de sucre et de lait et si nécessaire approvisionner la machine

Différent cas d'extention de notre système : 
- Au début une machine simple,
- Nous recevons une machine a café Expresso qui fait des "Expresso" et des "Capuccino"
  - Voir branche __Expresso__
  - Ici il est possible d'utiliser la MachineACafe pour traiter notre nouvelle machine
- Nous recevons une machine a café only qui permet de faire des café court / long mais qui ne dispose pas de l'option lait.
  - Voir branche __CafeOnly__
  - Dans ce cas l'adaptation est impossible sans revoir la conseption


# Le principe de Ségrégation des Interfaces

Les clients d'une entité logicielle ne doivent pas avoir à dépendre d'un interface qu'ils n'utilisent pas.

Le client ne doit pas accéder aux opération de maintenance des machines
L'agent de maintenance doit maintenir les stocks et ne pas consommer de café