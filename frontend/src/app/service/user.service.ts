import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
  }

  serverUrl = 'http://localhost:8080';

  isLoggedIn: boolean;

  logIn(login: string, password: string){
    return this.http.get<User>(this.serverUrl+'/user/'+login).subscribe(u =>{
      if(u.login == login && u.password == password){
        this.isLoggedIn = true;
      }else this.isLoggedIn = false;
    });
  }

}
