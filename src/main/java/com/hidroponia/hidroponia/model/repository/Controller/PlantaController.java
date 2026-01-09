package com.hidroponia.hidroponia.model.repository.Controller;

import com.hidroponia.hidroponia.model.Planta;
import com.hidroponia.hidroponia.model.repository.PlantaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlantaController {

    private final PlantaRepository plantaRepository;

    public PlantaController(PlantaRepository plantaRepository) {
        this.plantaRepository = plantaRepository;
    }

    // LISTAR
    @GetMapping("/hidroponia")
    public String inicio(Model model) {
        model.addAttribute("plantas", plantaRepository.findAll());
        return "index";
    }

    // AGREGAR
    @SuppressWarnings("null")
    @PostMapping("/agregar")
    public String agregarPlanta(@ModelAttribute Planta planta) {
        plantaRepository.save(planta);
        return "redirect:/hidroponia";
    }

    // MOSTRAR FORMULARIO PARA EDITAR
    @SuppressWarnings("null")

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
    Planta planta = plantaRepository.findById(id).orElse(null);
    model.addAttribute("planta", planta);
    return "editar";
    }

    // ACTUALIZAR
    @SuppressWarnings("null")
    @PostMapping("/actualizar/{id}")
    public String actualizarPlanta(@PathVariable Long id, @ModelAttribute Planta datosActualizados) {
    Planta planta = plantaRepository.findById(id).orElse(null);

    if (planta != null) {
        planta.setNombre(datosActualizados.getNombre());
        planta.setTipo(datosActualizados.getTipo());
        planta.setFechaSiembra(datosActualizados.getFechaSiembra());
        planta.setNivelNutrientes(datosActualizados.getNivelNutrientes());
        plantaRepository.save(planta);
    }

    return "redirect:/hidroponia";
}


    // ELIMINAR
    @SuppressWarnings("null")
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        plantaRepository.deleteById(id);
        return "redirect:/hidroponia";
    }

    @PostMapping("/contactar")
    public String procesarContacto(
        @RequestParam String nombreCliente,
        @RequestParam String correo,
        @RequestParam String telefono,
        @RequestParam String motivo,
        @RequestParam String mensaje) {

    // Construir mensaje para WhatsApp
    String texto = "Hola, quiero más información.%0A"
            + "%0A*Nombre:* " + nombreCliente
            + "%0A*Correo:* " + correo
            + "%0A*Teléfono:* " + telefono
            + "%0A*Motivo:* " + motivo
            + "%0A*Mensaje:* " + mensaje;

    // URL de WhatsApp con tu número
    String url = "redirect:https://wa.me/527224931260?text=" + texto;

    return url;
}


 @GetMapping("/bitacora")  // Página de bitácora
    public String bitacora() {
        return "bitacora"; // busca bitacora.html en templates
    }



    
}