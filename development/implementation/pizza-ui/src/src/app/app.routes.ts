import { Routes } from '@angular/router';

import { AdminUebersichtComponent } from './admin-uebersicht/admin-uebersicht.component';
import { BestellUebersichtComponent } from './bestell-uebersicht/bestell-uebersicht.component';
import { BestellvorgangComponent } from './bestellvorgang';
import { HomeComponent } from './home';
import { LoginComponent } from './login/LoginComponent';
import { NoContentComponent } from './no-content';
import { SpeisekarteComponent } from './speisekarte/speisekarte.component';

export const ROUTES: Routes = [
  {path:       '',
    component: HomeComponent
  },
  // { path: 'home', component: HomeComponent },
  {path:       'bestellvorgang',
    component: BestellvorgangComponent
  },
  // { path: 'detail', loadChildren: './+detail#DetailModule' },
  // { path: 'barrel', loadChildren: './+barrel#BarrelModule' },
  {path:       'bestellungen',
    component: BestellUebersichtComponent
  },
  {
    path:      'speisekarte',
    component: SpeisekarteComponent
  },
  {
    path:      'admin',
    component: AdminUebersichtComponent
  },
  {
    path:      'login',
    component: LoginComponent
  },
  {
    path:      '**',
    component: NoContentComponent
  }
];
