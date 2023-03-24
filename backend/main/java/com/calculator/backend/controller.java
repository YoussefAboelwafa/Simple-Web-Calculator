package com.calculator.backend;

import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController

public class controller {
    @CrossOrigin
    @GetMapping("/{exp}")
    public String calculate(@PathVariable String exp){
        System.out.println(exp);
        Double ans ;
        String result;
        String [] s = exp.split(" ");

        double op1 ;
        String op;
        double op2;
        DecimalFormat df = new DecimalFormat("0.000000000");
        if(s.length==3) {
            op1 = Double.parseDouble(s[0]);
            op = s[1];
            op2 = Double.parseDouble(s[2]);
            switch (op) {
                case "+":
                    ans = op1 + op2;
                    break;
                case "-":
                    ans = op1 - op2;
                    break;
                case "x":
                    ans = op1 * op2;
                    break;
                case "div":
                  if(op2==0){return "ERROR";}
                  else {ans = op1 / op2;break;}
                case "mod":
                    if(op2==0){return "ERROR";}
                    else {ans = op1 % op2;break;}
                default:return "ERROR";
            }
        }
        else if(s.length==2){
            op=s[0];
            op1 =Double.parseDouble(s[1]);


            switch (op) {
                case "sqrt(":
                    ans = Math.sqrt(op1);
                    break;
                case "inv(":
                    if (op1 == 0) {
                        return "ERROR";
                    } else {
                        ans = 1 / op1;
                        break;
                    }
                case "pow^2(":
                    ans = Math.pow(op1, 2.0);
                    break;
                default:
                    return "ERROR";
            }

        }
        else return "ERROR";

        ans= Double.valueOf(df.format(ans));
        result = ans.toString();

        if(result.length()>13){return "Too large";}
        return result;
    }



}
