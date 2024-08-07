package com.beko.listner;

import com.beko.entity.Revision;
import org.hibernate.envers.RevisionListener;

public class AppRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        var revision = (Revision) revisionEntity;
//        revision.setUsername(SecurityContext.getUser());
        revision.setUsername("Bekooo");
    }
}


