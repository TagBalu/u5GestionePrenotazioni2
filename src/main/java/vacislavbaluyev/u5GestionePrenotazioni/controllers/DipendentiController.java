package vacislavbaluyev.u5GestionePrenotazioni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.BadRequestException;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.NewDipendenteDTO;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.NewDipendenteResponseDTO;
import vacislavbaluyev.u5GestionePrenotazioni.service.DipendentiService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    DipendentiService dipendentiService;

    @GetMapping
    public List<dipendente> getAllDipendenti() {
        return dipendentiService.getAll();
    }

    //1. -POST http://localhost:3001/dipendenti
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDipendenteResponseDTO saveDipendente(@RequestBody @Validated NewDipendenteDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        dipendente newDipendente = dipendentiService.save(body);
        return new NewDipendenteResponseDTO(newDipendente.getId());
    }

    //3 Get http://localhost:3001/dipendenti +/{id}

    @GetMapping("/{dipendenteId}")
    public dipendente findById(@PathVariable int dipendenteId) {
        return dipendentiService.findById(dipendenteId);
    }


    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDeleteById(@PathVariable int dipendenteId) {
        dipendentiService.findAndDeleteById(dipendenteId);

    }




}
