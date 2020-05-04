import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../service/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  isLoggedIn: boolean;

  constructor(private router: Router, private userService: UserService) {
    this.isLoggedIn = userService.isLoggedIn;
   }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(!this.isLoggedIn){
      this.router.navigate(['login']);
      return false;
    }else return true;
  }
  
}
