/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reproductor_de_Musica;

/**
 *
 * @author adalb
 */
public class Canciones {
    private String name;
    public String image;
    
    public Canciones(String name, String image){
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
