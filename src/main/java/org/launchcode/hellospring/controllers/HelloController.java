package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

     //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
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
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='POST'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }


    @RequestMapping(method = {RequestMethod.POST}, value = "helloLang")
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