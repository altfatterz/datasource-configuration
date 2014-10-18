package com.backbase.progfun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("!production")
public class DatabaseLoader {

    private final PageRepository pageRepository;
    private final PortalRepository portalRepository;

    @Autowired
    public DatabaseLoader(PageRepository pageRepository, PortalRepository portalRepository) {
        this.pageRepository = pageRepository;
        this.portalRepository = portalRepository;
    }

    @PostConstruct
    private void initDatabase() {
        Portal portal = new Portal("Haliho Gulf retail banking");
        portalRepository.save(portal);

        Page page = new Page();
        page.setName("login");
        page.setPortal(portal);
        pageRepository.save(page);

        page = new Page();
        page.setName("accounts");
        page.setPortal(portal);
        pageRepository.save(page);

        page = new Page();
        page.setName("profile");
        page.setPortal(portal);
        pageRepository.save(page);

    }
}

