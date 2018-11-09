package ee.valiit.demo.demo.service;

import ee.valiit.demo.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonService {

  List<Person> personsList = new ArrayList<>();

  @PostConstruct
  public void init(){
    Person firstP = new Person();
    firstP.setFirstName("Miki");
    firstP.setLastName("Hiir");
    firstP.setSocialSecurityId(310123456L);

    Person secondP = new Person();
    secondP.setFirstName("Hagar");
    secondP.setLastName("Hirmus");
    secondP.setSocialSecurityId(340123456L);

    Person thridP = new Person();
    thridP.setFirstName("Lady");
    thridP.setLastName("Gaga");
    thridP.setSocialSecurityId(480123456L);

    personsList.add(firstP);
    personsList.add(secondP);
    personsList.add(thridP);
    log.info("init done");
  }


  public Person getPerson(Long socialSecurityId){
    log.info("personList size {} {}", personsList.size(), socialSecurityId);

    Optional<Person> person = personsList.stream().filter((p -> p.getSocialSecurityId() == socialSecurityId)).findAny();
    log.info("Person {}", person.toString());
    if (person.isPresent()){
      return  person.get();
    }
    return new Person();
  }

}
