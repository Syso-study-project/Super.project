package syso.syso.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import syso.syso.dto.SignupDto;
import syso.syso.service.MemberService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/new")
    public List<String> signUp(@Valid SignupDto signupDto, BindingResult bindingResult, Model model){

        List<String> err = new ArrayList<>();

        if(bindingResult.hasErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){

                err.add(error.getDefaultMessage());
            }
            return err;
        }

        try{
            memberService.회원가입(signupDto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}