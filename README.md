# **RPG Metodologie**

Gioco di carte a scelte scritto in Java con JavaFX. Il giocatore è un ragazzo di strada nella città di Soddo (Etiopia) : a ogni turno un personaggio gli fa una richiesta e lui risponde con una delle due opzioni. Ogni risposta modifica salute, istruzione, paura e legame con la strada, e la partita finisce quando uno di questi parametri arriva al limite o quando le carte sono finite. Si può salvare la partita e scegliere tra tre livelli di difficoltà.

Il titolo e l'idea nascono dall'iniziativa "La strada non è casa" di *Mission estere dei cappuccini delle marche*, centro missionario che tra i vari progetti nella terra di missione dell'Etiopia, sostiene lo *Smiling children town* di Soddo, centro di accoglienza e reintegrazione sociale per bambini di strada. Con questo modello di RPG, si ha la possibilità di poter sviluppare varie versioni del gioco che possano raccontare vari drammi che avvengono giornalmente in Africa, dal punto di vista di chi li vive.

## **Come eseguire il progetto**

### **Prerequisiti**

- Java 25 (LTS)
- Gradle

### **Istruzioni**

```
git clone https://github.com/edoardomarconi-unicam/rpg-metodologie.git cd rpg-metodologie
```

### **Build del progetto**

```
./gradlew build
```

### **Esecuzione**

```
./gradlew run
```

### **Uso di strumenti di AI**

Ho usato Claude Code come supporto per:

- capire la causa di alcuni bug e degli errori che incontravo, che poi ho corretto da solo nel codice.
- chiarire dubbi sull'organizzazione delle classi e dei package e sull'uso dei pattern (Observer, MVC).
- scrivere una prima bozza della wiki, che ho riletto e corretto confrontandola con il codice.
