/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berat.konversi_berat;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maulana Alfiansyah
 */
@Controller
public class konversiBerat {
    private int beratPounds(int getKilogram){
        int pound = (int) (getKilogram * 2.20462);
        return pound;
    }
    
    private int beratOns(int getKilogram){
        int Ons = (int) (getKilogram *35.2739199982575);
        return Ons;
    }
    private int beratKuintal(int getKilogram){
        int kuintal = (int) (getKilogram /100);
        return kuintal;
    }
    private int beratGram(int getKilogram){
        int gram = (int) (getKilogram *1000);
        return gram;
    }
    @RequestMapping("/berat")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model databerat){
       String getBerat = data.getParameter("Berat");
       int getKilogram = Integer.parseInt(data.getParameter("Kilogram")); 
      
       int beratOns = beratOns(getKilogram);
       int beratPounds = beratPounds(getKilogram);
       int beratKuintal = beratKuintal(getKilogram);
       int beratGram = beratGram(getKilogram);
       
       databerat.addAttribute("Berat", getKilogram);
       databerat.addAttribute("Ons", beratOns);
       databerat.addAttribute("Pounds",beratPounds); 
       databerat.addAttribute("Kuintal",beratKuintal);
       databerat.addAttribute("Gram",beratGram);
       
       
       return "viewer";
       
    }     
}

