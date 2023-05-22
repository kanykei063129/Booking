package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.service.AgencyService;

@Controller
@RequestMapping("/agency")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyService agencyService;

    @GetMapping("/a")
    public String getAllAgency( Model model) {
        model.addAttribute("agency", agencyService.getAllAgency());
        return "/mainPage";
    }

    @GetMapping("/newAgency")
    public String createAgency(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "newAgency";
    }

    @PostMapping("/save")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency) {
        agencyService.saveAgency(agency);
        return "redirect:/agency";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        agencyService.deleteById(id);
        return "redirect:/agency";
    }
}
