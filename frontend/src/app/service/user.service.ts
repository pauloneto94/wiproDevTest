import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
  }

  serverUrl = 'http://localhost:8080';

  isLoggedIn: boolean;
  redirectUrl: string;

  logIn(login: string, password: string, router: Router): string{
    this.http.get<User>(this.serverUrl+'/user/'+login).subscribe(u =>{
      if(u.login == login && u.password == password){
        this.isLoggedIn = true;
        router.navigate(['/products']);
      }else{
        this.isLoggedIn = false;
      }
    });
    if(this.isLoggedIn) return "";
    else return "Login ou Senha inválido!";
  }

}
