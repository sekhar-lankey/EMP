package com.api.emp.employee;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/Employees")
public class EmployeeResource{

    @Autowired
    private EmployeeRepository EmployeeRepository;

    @GetMapping()
    public List<Employee> retrieveAllEmployees() {
        return EmployeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Employee> retrieveEmployee(@PathVariable long id) {
        Optional<Employee> Employee = EmployeeRepository.findById(id);

        if (Employee.isEmpty())
            throw new EmployeeNotFoundException("id-" + id);

        EntityModel<Employee> resource = EntityModel.of(Employee.get());

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllEmployees());

        resource.add(linkTo.withRel("all-Employees"));

        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        EmployeeRepository.deleteById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee Employee) {
        Employee savedEmployee = EmployeeRepository.save(Employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee Employee, @PathVariable long id) {

        Optional<Employee> EmployeeOptional = EmployeeRepository.findById(id);

        if (EmployeeOptional.isEmpty())
            return ResponseEntity.notFound().build();

        Employee.setId(id);

        EmployeeRepository.save(Employee);

        return ResponseEntity.noContent().build();
    }
}
