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
public class Animal {
    
    protected String nomeDono;
    protected int telefoneDono;
    
    protected String nome;
    protected int idade;
    
    public Animal(){}
    
    public Animal(String nome, int idade, String nomeDono, int telefoneDono){
        this.nome = nome;
        this.idade = idade;
        this.nomeDono = nomeDono;
        this.telefoneDono = telefoneDono;
    }
    
    public String emitirSom(){
        System.out.println("aguardando Som");
        return "...";
    }

}
