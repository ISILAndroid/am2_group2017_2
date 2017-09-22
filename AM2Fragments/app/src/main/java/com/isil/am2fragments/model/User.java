package com.isil.am2fragments.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 8/09/17.
 */

public class User  implements Serializable{

    private String name;
    private String dni;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
