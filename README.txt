1) Lancement du projet sur Docker

ssh -l core ensibs.westeurope.cloudapp.azure.com // Se connecter
mdp : InfoConfiance2018

docker pull jeromebq/methodesagiles // Charger le projet

docker run -d -p 83:80 --name mo jeromebq/methodesagiles // Lancer le projet

docker rm -fv mo // Fermer le processus

http://ensibs.westeurope.cloudapp.azure.com:83/demandes


2) Fonctionnalités présentes
	
Suite à nos sprint nous avons pu mettre en place différentes fonctionnalités qui était exigées par le client.
Nous avons listés les fonctionnalités opérationnelles ci dessous :

- Affichage des différentes demandes mises en place par des utilisateurs.
- Lien cliquable sur les différentes demandes.
- Pouvoir répondre à une demande.
- Création d'une demande par un utilisateur.
- Mise en place de cette demande dans la liste des demandes affichées.


3) Fonctionnement du service web

Lorsque nous arrivons sur le site, la première chose que nous voyons est la liste des demandes qui ont été ajoutées
au préalable dans la base de données.
A partir d'ici nous avons différents choix, nous pouvons soit :
- Cliquer sur une demande et accéder à la page pour répondre à cette demande.
- Cliquer sur un lien de création de demande et accéder à la page pour créer une nouvelle demande

Sur la page de création de demande, nous avons accès à un formulaire qui nous demande de renseigner plusieurs
champs afin de pouvoir créer une demande valide. Par la suite, lorsque celle-ci sera créer on nous redirigera
vers la page d'accueil avec la nouvelle demande que nous venons de créer qui sera ajoutée à la liste de
demande initialement créée.

Sur la page de réponse d'une demande, nous avons la demande qui s'affiche et deux boutons qui nous permettent
d'accepter ou de revenir à la lsite des demandes. Lorsque nous aurons répondu, la réponse sera enregistrée et la demande
sera notifiéde comme étant déjà votée dans la liste de demande.

4) Acteurs du projet

BÉCU Jérôme
CHEVREUL Mathieu
FOUCHER Maxime
HAMOUI Alexandre
NARD Aurélien
MULOT Tanguy
