package com.example.vacationhomedemo.serviceimpl;

import com.example.vacationhomedemo.model.Administrator;
import com.example.vacationhomedemo.repository.AdministratorRepository;
import com.example.vacationhomedemo.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository theAdministratorRepository)  {
        administratorRepository = theAdministratorRepository;
        }

    @Override
    public List<Administrator> findAll() { return administratorRepository.findAllByOrderByLastNameAsc(); }

    @Override
    public Administrator findById(int theId) {
        Optional<Administrator> result = administratorRepository.findById(theId);

        Administrator theAdministrator = null;

        if (result.isPresent()) {
            theAdministrator = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theAdministrator;
    }

    @Override
    public Administrator save(Administrator theAdministrator) { return administratorRepository.save(theAdministrator); }

    @Override
    public void deleteById(int theId) { administratorRepository.deleteById((theId)); }

}
