import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { User } from './User';


var users = [
  new User('thomas.michael@god.de', 'doener'),
  new User('aquadrat@bquadrat.com', 'cquadrat')
];

@Injectable()
export class AuthenticationService {

  constructor(private _router: Router) {
  }

  logout() {
    localStorage.removeItem('user');
    this._router.navigate(['Login']);
  }

  login(user) {
    var authenticatedUser = users.find(u => u.email === user.email);
    if (authenticatedUser && authenticatedUser.password === user.password) {
      localStorage.setItem('user', authenticatedUser.email + authenticatedUser.password);
      this._router.navigate(['./admin']);
      return true;
    }
    return false;

  }

  checkCredentials() {
    if (localStorage.getItem('user') === null) {
      this._router.navigate(['Login']);
    }
  }
}