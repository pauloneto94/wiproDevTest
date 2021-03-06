import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  message: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.userService.logOff();
  }

  logIn(){
    this.message = this.userService.logIn(this.email, this.password, this.router);
  }
}
