package com.example.ideabox.Question;


import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("question")
public class QuestionController {


    private QuestionService questionService;
    private CampaignService campaignService;


    public QuestionController(QuestionService questionService, CampaignService campaignService) {
        this.questionService = questionService;
        this.campaignService = campaignService;
    }

    @PostMapping("/new")
    public String postNewQuestion(@ModelAttribute QuestionForm form, HttpServletRequest request){
        Campaign campaign = (Campaign) campaignService.findById( form.getCampaignId() );
        QuestionClosed question = new QuestionClosed( campaign, form.getSentence(), form.getAllowNeutral() );
        questionService.create( question );
        return "redirect:/campaign/show/" + String.valueOf( campaign.getId() );
    }

    @PostMapping("/update-neutral")
    public String updateNeutrality(@RequestBody QuestionChangeNeutralForm questionForm){
        QuestionClosed q = (QuestionClosed) questionService.findQuestionById(questionForm.getQuestionId());
        q.setAllowNeutral(questionForm.getAllowNeutral());
        questionService.save(q);
        return "redirect:/campaign/show/"+q.getCampaign().getId();
    }
}
