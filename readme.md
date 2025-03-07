# Design Patterns en Java : Builder, Singleton et Prototype

## Pattern Builder

Le pattern Builder est un patron de conception créationnel qui permet de construire des objets complexes étape par étape.
Il est particulièrement utile lorsqu'un objet doit être créé avec de nombreux paramètres optionnels.

### Objectifs
- Permettre la création d'un objet complexe étape par étape
- Éviter les constructeurs avec trop de paramètres
- Assurer l'immutabilité de l'objet final
- Encapsuler le code de construction et de représentation

### Avantages
1. Construction flexible d'objets complexes
2. Code plus lisible avec une syntaxe fluide
3. Encapsulation du code de construction
4. Validation des données pendant la construction
5. Support des objets immuables

---

## Pattern Singleton

Le pattern Singleton est un patron de conception créationnel qui garantit qu'une classe ne possède 
qu'une seule instance et fournit un point d'accès global à cette instance.

### Objectifs
- Assurer qu'une classe n'a qu'une seule instance
- Fournir un point d'accès global à cette instance
- Contrôler l'accès concurrent à la ressource partagée
- Gérer le lazy loading de l'instance

### Avantages
1. Garantie d'une instance unique
2. Point d'accès global
3. Initialisation paresseuse possible
4. Réutilisation de l'instance
5. Contrôle strict sur l'instantiation

### Implémentations

#### 1. Méthode avec initialisation statique (Thread-safe)
```java
public class SingletonStatic {
    // Instance unique initialisée statiquement
    private static final SingletonStatic instance = new SingletonStatic();
    
    // Constructeur privé
    private SingletonStatic() {
        // Empêche l'instantiation directe
    }
    
    // Point d'accès global
    public static SingletonStatic getInstance() {
        return instance;
    }
}
```

#### 2. Méthode synchronized avec lazy loading
```java
public class SingletonSynchronized {
    // Instance unique
    private static SingletonSynchronized instance;
    
    // Constructeur privé
    private SingletonSynchronized() {
        // Empêche l'instantiation directe
    }
    
    // Point d'accès global synchronisé
    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
```
---
## Pattern Prototype

Le pattern Prototype est un patron de conception créationnel qui permet de créer de 
nouveaux objets en clonant un objet existant, appelé prototype.
Ce pattern est utilisé quand la création directe d'un objet est coûteuse ou complexe.

### Objectifs
- Créer de nouveaux objets en clonant un prototype
- Réduire le coût de création d'objets
- Éviter la création de sous-classes pour la création d'objets
- Masquer la complexité de création des objets

### Avantages
1. Réduction du coût de création d'objets
2. Création dynamique d'objets
3. Alternative à l'héritage pour la création d'objets
4. Configuration flexible des objets
5. Réduction de la complexité d'initialisation