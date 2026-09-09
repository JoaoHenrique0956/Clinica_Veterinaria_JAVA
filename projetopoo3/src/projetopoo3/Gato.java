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
public class Gato extends Animal{
    
    private String temperamento;
    
    public Gato(){
        super();
    }
    
    public Gato(String temperamento, String nome, int idade, String nomeDono, int telefoneDono){
        super(nome,idade,nomeDono,telefoneDono);
        this.temperamento = temperamento;
    }
    
    @Override
    public String emitirSom(){
        return "Miau!";
    }
}
