import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Router } from '@angular/router';
import { LOCAL_STORAGE, StorageService } from 'ngx-webstorage-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  serverUrl = 'http://localhost:8080';

  isLoggedIn: boolean;
  user: Observable<User>;
  redirectUrl: string;

  constructor(private http: HttpClient, @Inject(LOCAL_STORAGE) private storage: StorageService, private router: Router) {
    this.user = this.storage.get('local_user');
    if(this.user != null){
      this.isLoggedIn = true;
      if(this.redirectUrl){this.router.navigate(["/products"]);}
    }else {this.isLoggedIn = false;}
  }


  logIn(login: string, password: string, router: Router): string{
    this.http.get<User>(this.serverUrl+'/user/'+login).subscribe(u =>{
      if(u.login == login && u.password == password){
        this.isLoggedIn = true;
        router.navigate(['/products']);
        this.storage.set('local_user', u);
      }else{
        this.isLoggedIn = false;
      }
    });
    if(this.isLoggedIn) return "";
    else return "Login ou Senha inválido!";
  }

  logOff(){
    this.storage.set('local_user', null);
    this.router.navigate(['/login']);
    this.isLoggedIn = false;
  }

}
