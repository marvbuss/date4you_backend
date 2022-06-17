package com.tutego.date4you.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Authority implements GrantedAuthority {
    // TODO: 16.06.2022 fix authority table 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "unicorn_id")
    private Unicorn unicorn;

    public Authority(){};

    public Authority(String authority){
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Unicorn getUnicorn() {
        return unicorn;
    }

    public void setUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }
}
