package code.app.spy.controller;

import code.app.spy.beans.Mission;
import code.app.spy.database.MissionJDBC;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/spy")
public class HomeController {

    @Autowired
    private MissionJDBC missionJDBC;

    @GetMapping("/index")
    public String getAgents(Model model) {

        List<String> agents = Arrays.asList("Johnny English", "Natasha Romanova", "Austin Martins");
        model.addAttribute("agents", agents);
        model.addAttribute("mission", new Mission());

        return "index";
    }

    @PostMapping("/view-missions")
    public String getMissions(@ModelAttribute Mission mission, Model model, HttpServletRequest request) {
        String selectedAgent = mission.getAgent();
        if (selectedAgent != null && !selectedAgent.isEmpty()) {
            request.getSession().setAttribute("agent", selectedAgent);
        } else {
            selectedAgent = (String) request.getSession().getAttribute("agent");
        }
        List<Mission> missionByAgent = missionJDBC.getMissionByAgent(selectedAgent);
        model.addAttribute("missions", missionByAgent);
        model.addAttribute("agent", selectedAgent);
        return "missions";
    }

    @GetMapping("/create-mission")
    public String getCreateMissionPage(Model model, HttpServletRequest request) {
        String selectedAgent = (String) request.getSession().getAttribute("agent");
        List<String> agents = Arrays.asList("Johnny English", "Natasha Romanova", "Austin Martins");
        model.addAttribute("agents", agents);
        model.addAttribute("agent", selectedAgent);
        model.addAttribute("mission", new Mission());
        return "create-mission";
    }

    @PostMapping("/create-mission")
    public String createMission(@ModelAttribute Mission mission, Model model, @RequestParam("selectedAgent") String selectedAgent, HttpServletRequest request) {
        System.out.println("======"+selectedAgent+"++++++");
        if (selectedAgent != null && !selectedAgent.isEmpty()) {
            mission.setAgent(selectedAgent);
            missionJDBC.createMission(mission);
        }
        return "redirect:/spy/index";
    }

    @GetMapping("/edit-mission/{id}")
    public String getEditMissionPage(@PathVariable int id, Model model, HttpServletRequest request) {
        String selectedAgent = (String) request.getSession().getAttribute("agent");
        List<Mission> missionById = missionJDBC.getMissionById(id);
        model.addAttribute("mission", missionById.getFirst());
        model.addAttribute("agent", selectedAgent);
        return "edit-mission";
    }

    @PostMapping("/edit-mission/{id}")
    public String editMission(@ModelAttribute Mission mission, @PathVariable int id, Model model, HttpServletRequest request) {
        String selectedAgent = (String) request.getSession().getAttribute("agent");
        mission.setAgent(selectedAgent);
        missionJDBC.editMissionById(mission, id);
        return "redirect:/spy/index";
    }


    @GetMapping("/delete-mission/{id}")
    public String deleteMission(@PathVariable int id, Model model) {
        missionJDBC.deleteMissionById(id);
        return "redirect:/spy/index";
    }
}
