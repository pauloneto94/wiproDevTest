import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 

  }

  serverUrl = 'http://localhost:4200';

  logIn(user: User){
    return this.http.post<User>(this.serverUrl+'logIn', user).subscribe();
  }

}
