package com.example.vacationhomedemo.serviceimpl;

import com.example.vacationhomedemo.model.Employee;
import com.example.vacationhomedemo.repository.EmployeeRepository;
import com.example.vacationhomedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {employeeRepository = theEmployeeRepository;}

    @Override
    public List<Employee> findAll() {return employeeRepository.findAllByOrderByLastNameAsc();}

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) { return employeeRepository.save(theEmployee);}

    @Override
    public void deleteById(int theId) { employeeRepository.deleteById(theId); }
}
