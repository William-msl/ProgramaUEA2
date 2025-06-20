package com.mycompany.programauea2;

/**
 *
 * @author Will Mzzl
 */

public class Semana2 {

    public static void main(String[] args) {
        Guerrero g = new Guerrero("Guts", 20, 10, 4, 100, 4);
        Mago m = new Mago("Vanessa", 5, 15, 4, 100, 3);

        g.mostrar();
        m.mostrar();

        pelear(g, m);
    }

    public static void pelear(Personaje p1, Personaje p2) {
        int turno = 1;
        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\nTurno " + turno);
            p1.atacar(p2);
            if (p2.estaVivo()) {
                p2.atacar(p1);
            }
            turno++;
        }

        if (p1.estaVivo()) {
            System.out.println("\n" + p1.nombre + " ganó la pelea");
        } else if (p2.estaVivo()) {
            System.out.println("\n" + p2.nombre + " ganó la pelea");
        } else {
            System.out.println("\nEmpate");
        }
    }
}

// Clases en personajes
class Personaje {
    public String nombre;
    public int fuerza;
    public int inteligencia;
    public int defensa;
    public int vida;

    public Personaje(String nom, int f, int i, int d, int v) {
        nombre = nom;
        fuerza = f;
        inteligencia = i;
        defensa = d;
        vida = v;
    }

    public void mostrar() {
        System.out.println("\n" + nombre);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Defensa: " + defensa);
        System.out.println("Vida: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void morir() {
        vida = 0;
        System.out.println(nombre + " ha muerto");
    }

    public int daño(Personaje enemigo) {
        return fuerza - enemigo.defensa;
    }

    public void atacar(Personaje enemigo) {
        int daño = daño(enemigo);
        enemigo.vida -= daño;
        System.out.println(nombre + " atacó a " + enemigo.nombre + " e hizo " + daño + " de daño.");
        if (!enemigo.estaVivo()) {
            enemigo.morir();
        }
    }
}

// Subclase Guerrero
class Guerrero extends Personaje {
    public int espada;

    public Guerrero(String nom, int f, int i, int d, int v, int e) {
        super(nom, f, i, d, v);
        espada = e;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Espada: " + espada);
    }

    @Override
    public int daño(Personaje enemigo) {
        return (fuerza * espada) - enemigo.defensa;
    }
}

// Subclase Mago
class Mago extends Personaje {
    public int libro;

    public Mago(String nom, int f, int i, int d, int v, int l) {
        super(nom, f, i, d, v);
        libro = l;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Libro: " + libro);
    }

    @Override
    public int daño(Personaje enemigo) {
        return (inteligencia * libro) - enemigo.defensa;
    }
}