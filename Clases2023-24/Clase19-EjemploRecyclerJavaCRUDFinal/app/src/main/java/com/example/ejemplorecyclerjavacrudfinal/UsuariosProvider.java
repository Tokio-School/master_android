package com.example.ejemplorecyclerjavacrudfinal;

import java.util.ArrayList;

public class UsuariosProvider {
    private ArrayList<Usuario> usuarios =new ArrayList<>();
    public UsuariosProvider()  {
        usuarios.add(new Usuario(20,"Juan","1234567890"));
        usuarios.add(new Usuario(25,"Pedro","1234567890"));
        usuarios.add(new Usuario(30,"Maria","1234567890"));
        usuarios.add(new Usuario(35,"Luis","1234567890"));
        usuarios.add(new Usuario(40,"Ana","1234567890"));
        usuarios.add(new Usuario(45,"Jose","1234567890"));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

