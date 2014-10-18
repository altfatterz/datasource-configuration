package com.backbase.progfun;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@JsonIgnoreProperties("new")
public class Portal extends AbstractPersistable<Long> {

    private String name;

    @OneToMany(mappedBy = "portal", cascade = CascadeType.ALL)
    private List<Page> pages = Collections.emptyList();

    private Portal() {}

    public Portal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void addPage(Page page) {
        if (pages == Collections.EMPTY_LIST) {
            pages = new ArrayList<>();
        }
        pages.add(page);
    }
}
