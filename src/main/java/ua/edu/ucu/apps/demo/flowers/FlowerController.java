package ua.edu.ucu.apps.demo.flowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequestMapping("/flowers")
@RestController
public class FlowerController {
    private final FlowerService service;

    @Autowired
    public FlowerController(FlowerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Flower> getAllFlowers() {
        return this.service.getFlowers();
    }

    @PostMapping
    public void addFlower(@RequestBody Flower flower) {
        service.addFlower(flower);
    }
}
