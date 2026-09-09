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
public class Consulta {
    
    private Animal animal;
    private int horario;
    private String sintomas;
    
    public Consulta(){}
    
    public Consulta(Animal animal, int horario, String sintomas){
        this.animal = animal;
        this.horario = horario;
        this.sintomas = sintomas;
    }
    
    public int getHorario(){
        return horario;
    }
    
    public void setHorario(int horario){
        this.horario = horario;
    }
    
    public String getSintomas(){
        return sintomas;
    }
    
    public void setSintomas(String sintomas){
        this.sintomas = sintomas;
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    
    public String getAnimalNome(){
        return animal.nome;
    }
    
    public int getAnimalIdade(){
        return animal.idade;
    }
    
    public String getDonoNome(){
        return animal.nomeDono;
    }

    public int getDonoTel(){
        return animal.telefoneDono;
    }
}
