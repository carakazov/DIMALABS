package lab.controllers;

import lab.model.FilmDao;
import lab.model.Film;
import lab.model.IFilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IFilmDao filmDao;
    public void setDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @RequestMapping(value = "/index")
    public String showAll(Model model){
        List<Film> films = null;
        try{
            films = filmDao.getAll();
        } catch (Exception e){
            return "redirect:/error";
        }
        model.addAttribute("list", films);
        return "index";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Film film){
        try{
            filmDao.create(film);
        }catch (Exception e){
            return "redirect:/error";
        }
        return "redirect:/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        try{
            filmDao.delete(id);
        }catch (Exception e){
            return "redirect:/error";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "modify/{id}")
    public String modifyForm(@PathVariable(value = "id") int id, Model model) {
        Film film = null;
        try {
            film = filmDao.get(id);
            model.addAttribute("film", film);
            return "modify";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/modifyFilm", method = RequestMethod.POST)
    public String modify(@ModelAttribute(value = "film") Film film){
        try {
            filmDao.update(film);
            return "redirect:/index";
        } catch (Exception e) {
            return "error";
        }
    }
}
