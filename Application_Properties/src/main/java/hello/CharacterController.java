package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterRepository repository;

    @RequestMapping("/")
    public Iterable<Character> getAllCharacters(@RequestParam(value="name", defaultValue="all") String lastname) {
        if(lastname.equals("all"))
            return repository.findAll();
        else
            return repository.findByLastName(lastname);
    }

    @RequestMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public void saveCharacter(@RequestBody Character c){
        repository.save(c);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void saveCharacter(@PathVariable Long id, @RequestBody Character c){
        Character charac = repository.findOne(id);
        charac.setFirstName(c.getFirstName());
        charac.setLastName(c.getLastName());
        repository.save(charac);
    }
}
