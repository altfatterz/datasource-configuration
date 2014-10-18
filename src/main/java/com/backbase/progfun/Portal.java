package com.backbase.progfun;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portal extends AbstractPersistable<Long> {

    private String name;

    @OneToMany(mappedBy = "portal", cascade = CascadeType.ALL)
    private List<Page> pages;

    public String getName() {
        return name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void addPage(Page page) {
        pages.add(page);
    }
}
