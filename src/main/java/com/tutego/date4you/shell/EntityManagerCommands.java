package com.tutego.date4you.shell;

import com.tutego.date4you.domain.Photo;
import com.tutego.date4you.domain.Profile;
import com.tutego.date4you.domain.Unicorn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@ShellComponent
public class EntityManagerCommands {

    @Autowired
    EntityManager em;

    public EntityManagerCommands(EntityManager em){
        this.em = em;
    }

    @ShellMethod( "Find user profile" )
    public void findProfile(Long id){
        Profile searchedProfile = em.find( Profile.class, id );
        if(searchedProfile != null){
        System.out.println(searchedProfile);
        } else System.out.println("Emtpy Profile");
    }


    @ShellMethod( "Find user profile with min and max" )
    public void findProfileMinMax(short min, short max){
        TypedQuery<Profile> query = em.createQuery( "SELECT p FROM Profile p WHERE hornlength BETWEEN :min AND :max", Profile.class ).setParameter("min", Short.valueOf(min)).setParameter("max", Short.valueOf(max));
        List<Profile> profiles = query.getResultList();
        for ( Profile p : profiles )
            System.out.println( p.getNickname() );
    }

    @ShellMethod("Find matching profile for unicorn")
    public void findUnicornProfile(Long id){
        em.createQuery( "SELECT u FROM Unicorn u WHERE u.profile.id = :id", Unicorn.class )
                .setParameter("id", Long.valueOf(id))
                .getResultList()
                .forEach( unicorn -> System.out.println(unicorn.toString()));
    }

    @ShellMethod( "Display all photos of a given unicorn by ID" )
    public void photos( long id )   {
        Optional.ofNullable( em.find( Unicorn.class, id ) ).ifPresent( unicorn -> {
            for ( Photo photo : unicorn.getProfile().getPhotos() ) {
                System.out.println( photo.getName() );
            }
        });
    }
}
