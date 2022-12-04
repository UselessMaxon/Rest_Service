package org.ibs.service.bussines;

import org.ibs.service.domain.entity.Employee;
import org.slf4j.Logger;

public class GreetingServiceImpl2 implements GreetingService {

    private Logger log;

    public GreetingServiceImpl2(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee) {
        log.info("Hello from test versionnnnnn " + employee.getFirstName());
    }

}
