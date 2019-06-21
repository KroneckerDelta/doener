import '../styles/headings.css';
import '../styles/styles.scss';

import { ApplicationRef, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { PreloadAllModules, RouterModule } from '@angular/router';
import { createInputTransfer, createNewHosts, removeNgStyles } from '@angularclass/hmr';

import { AdminUebersichtComponent } from './admin-uebersicht/admin-uebersicht.component';
import { AppComponent } from './app.component';
import { APP_RESOLVER_PROVIDERS } from './app.resolver';
import { ROUTES } from './app.routes';
import { AppState, InternalStateType } from './app.service';
import { BestellUebersichtComponent } from './bestell-uebersicht';
import { GroupSizePipe } from './bestell-uebersicht/GroupSize';
import { BestellungService } from './bestellungService';
import { BestellvorgangComponent } from './bestellvorgang';
import { NumberValidatorDirective } from './bestellvorgang/numberValidator.directive';
import { ENV_PROVIDERS } from './environment';
import { HomeComponent } from './home';
import { XLargeDirective } from './home/x-large';
import { LoginComponent } from './login/LoginComponent';
import { NoContentComponent } from './no-content';
import { SpeisekarteComponent } from './speisekarte/speisekarte.component';
import { GodShowErrorComponent } from './validation/god-show-error/god-show-error.component';

/*
 * Platform and Environment providers/directives/pipes
 */
// App is our top level component
// Application wide providers
const APP_PROVIDERS = [
  ...APP_RESOLVER_PROVIDERS,
  AppState
];

type StoreType = {
  state: InternalStateType, restoreInputValues: () => void, disposeOldHosts: () => void
};

/**
 * `AppModule` is the main entry point into Angular2's bootstraping process
 */
@NgModule({
  bootstrap:    [AppComponent],
  declarations: [
    AppComponent,
    BestellvorgangComponent,
    HomeComponent,
    NoContentComponent,
    XLargeDirective,
    BestellUebersichtComponent,
    SpeisekarteComponent,
    GodShowErrorComponent,
    NumberValidatorDirective,
    GroupSizePipe,
    AdminUebersichtComponent,
    LoginComponent
  ],
  /**
   * Import Angular's modules.
   */
  imports:      [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES,
      {
        useHash:            true,
        preloadingStrategy: PreloadAllModules
      }
    )
  ],
  /**
   * Expose our Services and Providers into Angular's dependency injection.
   */
  providers:    [
    BestellungService,
    ENV_PROVIDERS,
    APP_PROVIDERS
  ]
})
export class AppModule {

  constructor(public appRef: ApplicationRef, public appState: AppState) {
  }

  public hmrOnInit(store: StoreType) {
    if (!store || !store.state) {
      return;
    }
    console.log('HMR store', JSON.stringify(store, null, 2));
    /**
     * Set state
     */
    this.appState._state = store.state;
    /**
     * Set input values
     */
    if ('restoreInputValues' in store) {
      let restoreInputValues = store.restoreInputValues;
      setTimeout(restoreInputValues);
    }

    this.appRef.tick();
    delete store.state;
    delete store.restoreInputValues;
  }

  public hmrOnDestroy(store: StoreType) {
    const cmpLocation = this.appRef.components.map((cmp) => cmp.location.nativeElement);
    /**
     * Save state
     */
    const state = this.appState._state;
    store.state = state;
    /**
     * Recreate root elements
     */
    store.disposeOldHosts = createNewHosts(cmpLocation);
    /**
     * Save input values
     */
    store.restoreInputValues = createInputTransfer();
    /**
     * Remove styles
     */
    removeNgStyles();
  }

  public hmrAfterDestroy(store: StoreType) {
    /**
     * Display new elements
     */
    store.disposeOldHosts();
    delete store.disposeOldHosts;
  }

}
