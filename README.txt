1) Lancement du projet sur Docker

ssh -l core ensibs.westeurope.cloudapp.azure.com // Se connecter
mdp : InfoConfiance2018

docker pull jeromebq/methodesagiles // Charger le projet

docker run -d -p 83:80 --name mo jeromebq/methodesagiles // Lancer le projet

docker rm -fv mo // Fermer le processus

http://ensibs.westeurope.cloudapp.azure.com:83/demandes


2) Fonctionnalit�s pr�sentes
	
Suite � nos sprint nous avons pu mettre en place diff�rentes fonctionnalit�s qui �tait exig�es par le client.
Nous avons list�s les fonctionnalit�s op�rationnelles ci dessous :

- Affichage des diff�rentes demandes mises en place par des utilisateurs.
- Lien cliquable sur les diff�rentes demandes.
- Pouvoir r�pondre � une demande.
- Cr�ation d'une demande par un utilisateur.
- Mise en place de cette demande dans la liste des demandes affich�es.


3) Fonctionnement du service web

Lorsque nous arrivons sur le site, la premi�re chose que nous voyons est la liste des demandes qui ont �t� ajout�es
au pr�alable dans la base de donn�es.
A partir d'ici nous avons diff�rents choix, nous pouvons soit :
- Cliquer sur une demande et acc�der � la page pour r�pondre � cette demande.
- Cliquer sur un lien de cr�ation de demande et acc�der � la page pour cr�er une nouvelle demande

Sur la page de cr�ation de demande, nous avons acc�s � un formulaire qui nous demande de renseigner plusieurs
champs afin de pouvoir cr�er une demande valide. Par la suite, lorsque celle-ci sera cr�er on nous redirigera
vers la page d'accueil avec la nouvelle demande que nous venons de cr�er qui sera ajout�e � la liste de
demande initialement cr��e.

Sur la page de r�ponse d'une demande, nous avons la demande qui s'affiche et deux boutons qui nous permettent
d'accepter ou de revenir � la lsite des demandes. Lorsque nous aurons r�pondu, la r�ponse sera enregistr�e et la demande
sera notifi�de comme �tant d�j� vot�e dans la liste de demande.

4) Acteurs du projet

B�CU J�r�me
CHEVREUL Mathieu
FOUCHER Maxime
HAMOUI Alexandre
NARD Aur�lien
MULOT Tanguy
