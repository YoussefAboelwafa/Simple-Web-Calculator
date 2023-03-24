import { HttpClient } from '@angular/common/http';
import { Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Calculator';
  display='0';
  currentValue=''
  
  
  constructor(private http:HttpClient){
  }
  

  click (value:string){
    if(this.currentValue[this.currentValue.length-1]=='(' || this.currentValue[this.currentValue.length-1]=='d' 
    || this.currentValue[this.currentValue.length-1]=='v' || this.currentValue[this.currentValue.length-1]=='+'
    ||  this.currentValue[this.currentValue.length-1]=='x' ||
    this.currentValue[this.currentValue.length-1]=='/'){this.currentValue=this.currentValue+" "+value;}
    else {this.currentValue+=value;}
    this.display=this.currentValue;
  }

  clr(){
    this.currentValue='';
    this.display='0';
  }
  del(){
    
    this.currentValue=this.currentValue.slice(0,-1);
    if(this.currentValue.length==0){this.display='0'}
    else{
    this.display=this.currentValue;
    }
    if(this.currentValue[this.currentValue.length-1]==" "){this.currentValue=this.currentValue.slice(0,-1);}
  }

  eql(){
    console.log(this.display)
    this.backend();
  }
  
  backend() {
    this.http.get("http://localhost:8080/"+this.display,{responseType:'text'}).subscribe(data=>this.display=data);
  }
}
