package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

     //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // form using GET
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" + // submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // form using POST, lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    Book Exercises ⤵

    @RequestMapping(method = {RequestMethod.POST}, value = "helloLang")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        switch (language) {
            case "French":
                return "Bonjour, " + name + "!";
            case "Spanish":
                return "Hola, " + name + "!";
            case "German":
                return "Guten tag, " + name + "!";
            case "Italian":
                return "Ciao, " + name + "!";
            case "Hindi":
                return "Namaste, " + name + "!";
            default:
                return "Hello, " + name + "!";
        }
    }

    @GetMapping("form2")
    @ResponseBody
    public String helloForm2() {
        return "<html>" +
                    "<body>" +
                        "<form action='helloLang' method='post'>" +
                            "<input type='text' name='name' />" +
                            "<select name='language'>" +
                                "<option value='' selected hidden>-- Select language --</option>" +
                                "<option value='French'>French</option>" +
                                "<option value='Spanish'>Spanish</option>" +
                                "<option value='German'>German</option>" +
                                "<option value='Italian'>Italian</option>" +
                                "<option value='Hindi'>Hindi</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}