package com.backbase.progfun;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Page extends AbstractPersistable<Long> {

    private String name;

    @ManyToOne
    private Portal portal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    @Override
    public String toString() {
        return "\"" + name + "\" " + "page of the \"" + portal.getName() +"\" portal";
    }
}
