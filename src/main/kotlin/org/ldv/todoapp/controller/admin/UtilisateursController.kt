package org.ldv.todoapp.controller.admin

import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UtilisateursController(
    private val utilisateurRepository: UtilisateurRepository
) {

    @GetMapping("/admin/utilisateurs")
    fun utilisateurs(model: Model): String {

        // Récupération de tous les utilisateurs avec leur rôle
        val utilisateurs = utilisateurRepository.findAllAvecRole()

        // Transmission de la liste au modèle
        model.addAttribute("listeUtilisateurs", utilisateurs)

        // Affichage du template admin/utilisateurs.html
        return "admin/utilisateurs"
    }
}
