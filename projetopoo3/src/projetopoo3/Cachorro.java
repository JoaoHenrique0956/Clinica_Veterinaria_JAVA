/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo3;

/**
 *
 * @author setor
 */
public class Cachorro extends Animal{
    private String raca;
    
    public Cachorro(){
        super();
    }
    
    public Cachorro(String raca, String nome, int idade, String nomeDono, int telefoneDono){
        super(nome,idade,nomeDono,telefoneDono);
        this.raca = raca;
    }
    
    @Override
    public String emitirSom(){
        return "Au Au!";
    }
    
    
}
