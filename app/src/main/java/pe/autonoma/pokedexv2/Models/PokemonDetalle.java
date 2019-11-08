package pe.autonoma.pokedexv2.Models;

import android.content.Intent;

public class PokemonDetalle
{
    private Integer base_experience;
    private Integer height;
    private String name;
    private String weight;
    //tipo

    public Integer getBase_experience()
    {
        return base_experience;
    }

    public void setBase_experience(Integer base_experience)
    {
        this.base_experience = base_experience;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }
}
