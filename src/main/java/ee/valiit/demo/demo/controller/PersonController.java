package ee.valiit.demo.demo.controller;


import ee.valiit.demo.demo.model.Person;
import ee.valiit.demo.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PersonController {


  @Autowired PersonService personService;

  @RequestMapping("/person/{socialSecurityId}")
  public Person getPerson(@PathVariable Long socialSecurityId){
    log.info("kas kood jouab siia {}", socialSecurityId);
    return personService.getPerson(socialSecurityId);

  }

}
