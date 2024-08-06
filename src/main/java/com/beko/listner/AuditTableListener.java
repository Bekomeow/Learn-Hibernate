package com.beko.listner;

import com.beko.entity.Audit;
import org.hibernate.event.spi.*;

public class AuditTableListener implements PreDeleteEventListener, PreInsertEventListener {
    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        auditEntity(event, Audit.Operation.DELETE);
        return false;
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        auditEntity(event, Audit.Operation.INSERT);
        return false;
    }

    private static void auditEntity(AbstractPreDatabaseOperationEvent event, Audit.Operation operation) {
        if(event.getEntity().getClass() != Audit.class) {
            var audit = Audit.builder()
                    .entityId(event.getId())
                    .entityName(event.getEntityName())
                    .entityContent(event.getEntity().toString())
                    .operation(operation)
                    .build();
            event.getSession().save(audit);
        }
    }
}

