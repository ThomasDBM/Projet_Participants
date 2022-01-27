package colloque.controllers;

import colloque.models.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/myarticle")
    public String getMyArticle(Model model) {
        Article art = new Article();
        model.addAttribute("myarticle",art); // Ajout au modèle
        return "article"; //Envoi vers la vue
    }
}
