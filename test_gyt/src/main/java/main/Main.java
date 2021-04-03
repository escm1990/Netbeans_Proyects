package main;

import com.devskiller.httpclientcrud.DalqpCharactersClient;

public class Main {
    
    public static void main(String[] args) {
        
        DalqpCharactersClient dcc = new DalqpCharactersClient("", "");
    
        dcc.createCharacter("Hola", "Carrera2");
        dcc.createCharacter("Hola2", "Carrera1");
        
    }
    
    
}
