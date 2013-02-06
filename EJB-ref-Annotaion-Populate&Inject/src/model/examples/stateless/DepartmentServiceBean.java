package examples.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class DepartmentServiceBean implements DepartmentService {
   
	@EJB private AuditService audit;
     public void performAudit() {
        audit.audit();
    }

}

