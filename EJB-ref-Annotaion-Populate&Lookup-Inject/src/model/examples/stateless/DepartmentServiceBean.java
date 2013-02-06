package examples.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
@EJB(name="audit", beanInterface=AuditService.class)
public class DepartmentServiceBean implements DepartmentService {
  
   @Resource SessionContext context;
   AuditService audit;
	
    public void performAudit() {
    	audit = (AuditService) context.lookup("audit");
        audit.audit();
    }
    
    // ...
}

