
package org.ldv.todoapp.controller.admin

import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TachesController(
    private val tacheRepository: TacheRepository
) {

    @GetMapping("/admin/taches")
    fun taches(model: Model): String {

        // Récupération de toutes les tâches
        // avec leurs utilisateurs associés
        val taches = tacheRepository.findAllAvecUtilisateur()

        // Transmission de la liste au modèle
        model.addAttribute("listeTaches", taches)

        // Affichage du template admin/taches.html
        return "admin/taches"
    }
}
