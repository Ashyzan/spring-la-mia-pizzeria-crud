# spring-la-mia-pizzeria-crud
Applicazione web che gestisce la pizzeria.

# PARTE 1
Creazione della prima pagina (index) dove mostro tutte le pizze.

Una pizza avrà le seguenti informazioni :
- un nome
- una descrizione
- una foto (url)
- ingredienti
- un prezzo
- 
Creazione del database db_pizzeria, repository e l'entity per gestire le CRUD delle pizze.
Implementazione del controller con il metodo index che restituisce una view (con boostrap) per mostrare l’elenco delle pizze caricate dal database 
L’elenco potrebbe essere vuoto : in quel caso mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella applicazione.
Gestione  dei componenti riutilizzabili con i fragments.

# PARTE 2
Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato porterà a una pagina che mostrerà i dettagli della pizza scelta.
Dobbiamo quindi inviare l’id come parametro dell’URL, recuperarlo nel metodo del controller, caricare i dati della pizza ricercata e passarli come model.
La view a quel punto li mostrerà all’utente con la grafica che preferiamo.
Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se compilato filtrerà le pizze (lato server) aventi come titolo quello inserito dall’utente.

# 3 nuove implementazioni 
Abbiamo la lista delle pizze, abbiamo i dettagli delle pizze...perchè non realizzare la pagina per la creazione di una nuova pizza?
Aggiungiamo quindi tutto il codice necessario per mostrare il form per la creazione di una nuova pizza e per il salvataggio dei dati in tabella.
Nella index creiamo ovviamente il bottone “Crea nuova pizza” che ci porta a questa nuova pagina creata.
Ricordiamoci che l’utente potrebbe sbagliare inserendo dei dati : gestiamo quindi la validazione!
Ad esempio verifichiamo che :
- i dati della pizza siano tutti presenti
- il campi di testo non superino una certa lunghezza
- il prezzo abbia un valore valido (ha senso una pizza con prezzo minore o uguale a zero?)
