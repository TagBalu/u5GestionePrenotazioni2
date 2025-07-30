package vacislavbaluyev.u5GestionePrenotazioni.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.LoginDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login (@RequestBody LoginDTO body){}
}
